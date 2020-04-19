package com.zth.springboot.bean;

/**
 * @author Kai
 * @date 2020/4/17 19:30
 */
public class Dept {
    private Integer id;
    private String deptName;

    public Dept(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Dept(Integer id) {
        this.id = id;
    }

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    public Dept() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}