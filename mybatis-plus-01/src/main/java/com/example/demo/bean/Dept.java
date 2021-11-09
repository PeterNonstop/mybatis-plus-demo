package com.example.demo.bean;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * Created with IntelliJ IDEA.
 * To change it use File | Settings | Editor | File and Code Templates.
 *
 * @author Peter
 * @date 2021/11/8 15:29
 * @description TODO
 */
public class Dept extends Model<Dept> {
    private Integer id;
    private String name;
    private String mobile;
    private Integer manager;

    public Dept() {
    }

    public Dept(Integer id, String name, String mobile, Integer manager) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", manager=" + manager +
                '}';
    }
}
