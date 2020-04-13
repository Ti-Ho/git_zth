package com.example.test;
import com.example.test.pojo.Student;
import com.example.test.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Test
    void test02(){
        List<Student> students = studentService.getAllStudent();
        System.out.println("students = " + students);
    }
}
