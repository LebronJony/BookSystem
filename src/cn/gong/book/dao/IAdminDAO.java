package cn.gong.book.dao;

/*
继承IDAO接口
 */
import cn.gong.book.vo.Admin;

import java.sql.SQLException;
import java.util.Date;

public interface IAdminDAO extends IDAO<String, Admin> {
    /*
    实现用户登录检查操作
    vo表示要执行检查的对象（aid，password，flag）
    成功返回true，失败返回false
     */
    public boolean findLogin(Admin vo)throws SQLException;

    /**
     * 实现用户数据更新操作
     * aid 表示要更新的主键
     */
    public boolean doUpdateByLastDate(String aid)throws SQLException;
}
