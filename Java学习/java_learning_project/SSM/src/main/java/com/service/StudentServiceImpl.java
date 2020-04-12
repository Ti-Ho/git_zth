package com.service;

import com.dao.StudentDao;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//serviceImpl
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentDao;
    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}
