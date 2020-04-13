package com.example.test.controller;

import com.example.test.pojo.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController         //会将返回结果 转换为一个JSON串
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping //"GET操作"
    List<Student> getAllStudents(){
        return studentService.getAllStudent();
    };
}


//运行后 访问 http://localhost:8080/students