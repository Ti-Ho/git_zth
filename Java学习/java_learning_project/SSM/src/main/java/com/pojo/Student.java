package com.pojo;
//student
public class Student {
    private String stuID;
    private String stuName;
    private String stuSex;
    private String stuMajor;
    @Override
    public String toString() {
        return "Student{" +
                "stuID='" + stuID + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                '}';
    }
    public String getStuID() {
        return stuID;
    }
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuSex() {
        return stuSex;
    }
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }
    public String getStuMajor() {
        return stuMajor;
    }
    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }
}
