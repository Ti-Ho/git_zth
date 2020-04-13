package com.example.test;

import com.example.test.mapper.StudentMapper;
import com.example.test.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;
    @Test
    void test01(){
        List<Student> students = studentMapper.getAllStudents();
        //student.soutv 快捷键
        System.out.println("students = " + students);
    }
}
