package cn.gong.book.service;

import cn.gong.book.vo.Books;

import java.util.List;
import java.util.Map;

public interface IBooksService {
    /*
    增加图书详情
     */
    public boolean insert(Books vo)throws Exception;

    /*
    表示执行查询admin和item表中的全部数据
     */
    public Map<String,Object> findByAdminAndItem()throws Exception;

    /*
    定义分页接口
     */
    public Map<String,Object> listBySplit(String column,String keyWord,int currentPage,int lineSize)throws Exception;


}
