package cn.gong.book.factory;

import cn.gong.book.dao.*;
import cn.gong.book.dao.impl.*;

import java.sql.Connection;

public class DAOFactory {
    public static IAdminDAO getIAdminDAOInstance(Connection conn){
        return new AdminDAOImpl(conn);
    }
    public static IMemberDAO getIMemberDAOInstance(Connection conn){
        return new MemberDAOImpl(conn);
    }

    public static IItemDAO getIItemDAOInstance(Connection conn){
        return new ItemDAOImpl(conn);
    }
    public static IBooksDAO getIBooksDAOInstance(Connection conn){
        return new BooksDAOImpl(conn);
    }
    public static ILenbooksDAO getILenbooksDAOInstance(Connection conn){
        return new LenBooksDAOImpl(conn);
    }
}
