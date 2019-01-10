package cn.gong.book.service;

import cn.gong.book.vo.Admin;

public interface IAdminService {
    /*
    实现管理员登录检查操作，调用AdminDAO接口中的findLogin（）方法
    vo表示要操作的对象，包括aid，password
    成功返回true，并且将最后一次登录日期传递到页面，失败返回false
     */
    public boolean login(Admin vo)throws Exception;

    public boolean insert(Admin vo)throws Exception;
}
