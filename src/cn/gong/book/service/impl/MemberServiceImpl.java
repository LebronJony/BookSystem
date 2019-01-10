package cn.gong.book.service.impl;

import cn.gong.book.dbc.DatabaseConnection;
import cn.gong.book.factory.DAOFactory;
import cn.gong.book.service.IMemberService;
import cn.gong.book.vo.Member;

public class MemberServiceImpl implements IMemberService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Member vo) throws Exception {
        try {
            // 表示mid数据不存在
            if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findByID(vo.getMid()) == null){
                return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
            }
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return false;
    }
}
