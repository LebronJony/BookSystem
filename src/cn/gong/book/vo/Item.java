package cn.gong.book.vo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private Integer iid;
    private String name;
    private String note;
    private List<Books> book; //表示一个类别下有多本书

    public List<Books> getBook() {
        return book;
    }

    public void setBook(List<Books> book) {
        this.book = book;
    }


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
