package cn.gong.book.factory;

import cn.gong.book.service.*;
import cn.gong.book.service.impl.*;

public class ServiceFactory {
    public static IAdminService getIAdminServiceInstance(){
        return new AdminServiceImpl();
    }
    public static IMemberService getIMemberServiceInstance(){
        return  new MemberServiceImpl();
    }
    public static IItemService getIItemServiceInstance(){
        return new ItemServiceImpl();
    }
    public static IBooksService getIBooksServiceInstance(){
        return new BooksServiceImpl();
    }
    public static ILenbooksService getILenbooksServiceInstance(){
        return new LenbooksServiceImpl();
    }
}
