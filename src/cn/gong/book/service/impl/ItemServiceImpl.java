package cn.gong.book.service.impl;

import cn.gong.book.dbc.DatabaseConnection;
import cn.gong.book.factory.DAOFactory;
import cn.gong.book.service.IItemService;
import cn.gong.book.vo.Item;

import java.util.List;

public class ItemServiceImpl implements IItemService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Item vo) throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Item> list() throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }
}
