package cn.gong.book.service.impl;

import cn.gong.book.dbc.DatabaseConnection;
import cn.gong.book.factory.DAOFactory;
import cn.gong.book.service.IBooksService;
import cn.gong.book.vo.Books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksServiceImpl implements  IBooksService {
    private DatabaseConnection dbc  =new DatabaseConnection();
    @Override
    public boolean insert(Books vo) throws Exception {
        try{
            return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> findByAdminAndItem() throws Exception {
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("allAdmins" ,DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findAll());
            map.put("allItems",DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll());
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listBySplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("allBooks" ,DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAllBySplit(column,keyWord,currentPage,lineSize));
            map.put("allCounts",DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).getAllCount(column,keyWord));
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }


}
