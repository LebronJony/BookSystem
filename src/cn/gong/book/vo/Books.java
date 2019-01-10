package cn.gong.book.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Books implements Serializable {
    private Integer bid;
    private String name;
    private Date credate;
    private Integer status;
    private String note;
    private Item Item; //表示一本书属于一个类别,iid
    private Admin admin; //表示图书有谁增加,aid
    private List<Lenbooks> Lenbooks; //表示可以借多本书

    public List<Lenbooks> getLenbooks() {
        return Lenbooks;
    }

    public void setLenbooks(List<Lenbooks> lenbooks) {
        Lenbooks = lenbooks;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public cn.gong.book.vo.Item getItem() {
        return Item;
    }

    public void setItem(cn.gong.book.vo.Item item) {
        Item = item;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
