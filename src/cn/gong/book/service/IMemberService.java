package cn.gong.book.service;

import cn.gong.book.vo.Member;

public interface IMemberService {
    /*
    实现数据增加操作
    vo表示要执行增加的对象
     */
    public boolean insert(Member vo)throws Exception;
}
