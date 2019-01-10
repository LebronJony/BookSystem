package cn.gong.book.service;

import cn.gong.book.vo.Lenbooks;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public interface ILenbooksService {

    /*
    实现数据增加操作
     */
    public boolean insert(Lenbooks vo)throws Exception;

    /*
    取得books数据和member数据
     */
    public Map<String,Object> listByMemberAndBooks()throws Exception;

    /*
    实现分页操作
     */
    public Map<String,Object> listBySplit(String column, String keyWord, int currentPage, int lineSize)throws Exception;

    /*
    实现数据更新归还日期
     */
    public boolean updateByRetdate(int leid)throws Exception;
}
