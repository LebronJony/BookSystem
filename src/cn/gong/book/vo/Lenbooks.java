package cn.gong.book.vo;

import java.io.Serializable;
import java.util.Date;

public class Lenbooks implements Serializable {
    private Integer leid;
    private Books books;    //表示图书编号
    private Member member; //表示用户id
    private Date credate; //表示借书日期
    private Date retdate; //表示图书归还日期

    public Integer getLeid() {
        return leid;
    }

    public void setLeid(Integer leid) {
        this.leid = leid;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Date getRetdate() {
        return retdate;
    }

    public void setRetdate(Date retdate) {
        this.retdate = retdate;
    }
}
