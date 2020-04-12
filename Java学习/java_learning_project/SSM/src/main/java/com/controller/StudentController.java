package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//controller
@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("showStudent")
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        List<Student> list = studentService.getAllStudent();

        mav.addObject("list", list);
        mav.setViewName("showStudent");
        return mav;
    }
    @RequestMapping("/addStudent")
    public  ModelAndView add(Student student) throws Exception{
        ModelAndView mav = new ModelAndView("showStudent");
        return mav;
    }
}
