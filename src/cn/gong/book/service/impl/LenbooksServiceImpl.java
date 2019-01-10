package cn.gong.book.service.impl;

import cn.gong.book.dbc.DatabaseConnection;
import cn.gong.book.factory.DAOFactory;
import cn.gong.book.service.ILenbooksService;
import cn.gong.book.vo.Lenbooks;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LenbooksServiceImpl implements ILenbooksService {

    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Lenbooks vo) throws Exception {
        try {
            return DAOFactory.getILenbooksDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }
        finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listByMemberAndBooks() throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("allBooks",DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAll());
            map.put("allMembers",DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAll());
            return map;
        }catch (Exception e){
            throw e;
        }
        finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put("allLenbooks",DAOFactory.getILenbooksDAOInstance(this.dbc.getConn()).findAllBySplit(column,keyWord,currentPage,lineSize));
            map.put("allLenbooksCounts",DAOFactory.getILenbooksDAOInstance(this.dbc.getConn()).getAllCount(column,keyWord));
            return map;
        }catch (Exception e){
            throw e;
        }
        finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateByRetdate(int leid) throws Exception {
        try {
            return DAOFactory.getILenbooksDAOInstance(this.dbc.getConn()).doUpdateByretdate(leid,new Date());
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }


}
