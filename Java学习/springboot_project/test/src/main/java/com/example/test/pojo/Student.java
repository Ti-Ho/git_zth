package com.example.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       //一些getter setter
@NoArgsConstructor          //无参构造器
@AllArgsConstructor
public class Student {
    private String name;
    private int gender;
    private String major;
}
