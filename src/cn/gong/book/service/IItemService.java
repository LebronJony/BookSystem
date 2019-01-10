package cn.gong.book.service;

import cn.gong.book.vo.Item;

import java.util.List;

public interface IItemService {
    /*
    实现分类的增加
    vo表示要执行增加的vo对象
     */
    public boolean insert(Item vo)throws Exception;

    /*
    实现数据全部查询操作接口
     */
    public List<Item> list()throws Exception;
}
