package cn.gong.book.vo;

import java.io.Serializable;
import java.util.List;

public class Member implements Serializable {
    private String mid;
    private String name;
    private Integer age;
    private Integer sex;
    private String phone;
    private List<Lenbooks> Lenbooks;

    public List<Lenbooks> getLenbooks() {
        return Lenbooks;
    }

    public void setLenbooks(List<Lenbooks> lenbooks) {
        Lenbooks = lenbooks;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
