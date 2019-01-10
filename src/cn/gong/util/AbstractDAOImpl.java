package cn.gong.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
定义一个抽象类，实现dao接口中的一些公共方法
 */
public abstract class AbstractDAOImpl {

    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(Connection conn){
        this.conn=conn;
    }
}
