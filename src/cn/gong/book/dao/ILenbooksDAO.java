package cn.gong.book.dao;

import cn.gong.book.vo.Lenbooks;

import java.sql.SQLException;
import java.util.Date;

public interface ILenbooksDAO extends IDAO<Integer, Lenbooks> {

    /*
实现归还更新日期操作
 */
    public boolean doUpdateByretdate(Integer leid, Date retdate)throws SQLException;
}
