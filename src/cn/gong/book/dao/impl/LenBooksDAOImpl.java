package cn.gong.book.dao.impl;

import cn.gong.book.dao.ILenbooksDAO;
import cn.gong.book.vo.Books;
import cn.gong.book.vo.Lenbooks;
import cn.gong.book.vo.Member;
import cn.gong.util.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class LenBooksDAOImpl extends AbstractDAOImpl implements ILenbooksDAO {
    public LenBooksDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Lenbooks vo) throws SQLException {
        String sql = "INSERT INTO lenbooks(bid,mid,credate) VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getBooks().getBid());
        super.pstmt.setString(2,vo.getMember().getMid());
        super.pstmt.setTimestamp(3,new Timestamp(vo.getCredate().getTime()));
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Lenbooks vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Lenbooks findByID(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Lenbooks> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Lenbooks> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Lenbooks> all = new ArrayList<Lenbooks>();
        String sql =" SELECT l.leid,b.name,m.name,l.credate,l.retdate " +
                " FROM  lenbooks l,books b,member m " +
                " WHERE l.bid = b.bid  AND l.mid = m.mid  AND l."+column+" LIKE ? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        super.pstmt.setInt(2,(currentPage-1) * lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Lenbooks vo = new Lenbooks();
            vo.setLeid(rs.getInt(1));
            Books books = new Books();
            books.setName(rs.getString(2));
            vo.setBooks(books); // bid
            Member member = new Member();
            member.setName(rs.getString(3));
            vo.setMember(member); // mid
            vo.setCredate(rs.getDate(4));
            vo.setRetdate(rs.getDate(5));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM lenbooks WHERE "+column+" LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doUpdateByretdate(Integer leid, Date retdate) throws SQLException {
        String sql = "UPDATE lenbooks SET retdate=? WHERE leid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1,new Timestamp(retdate.getTime()));
        super.pstmt.setInt(2,leid);
        return super.pstmt.executeUpdate() > 0;
    }
}
