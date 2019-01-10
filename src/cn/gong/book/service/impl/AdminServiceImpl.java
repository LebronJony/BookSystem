package cn.gong.book.service.impl;

import cn.gong.book.dbc.DatabaseConnection;
import cn.gong.book.factory.DAOFactory;
import cn.gong.book.service.IAdminService;
import cn.gong.book.vo.Admin;

public class AdminServiceImpl implements IAdminService {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            if(DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findLogin(vo)){
                return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean insert(Admin vo) throws Exception {
        try{
            if(DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findByID(vo.getAid()) == null){
                return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doCreate(vo);
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

}
