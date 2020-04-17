package com.zth.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Kai
 * @date 2020/4/16 0:18
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        /**
         * 在spring-boot-autoconfig.jar包中有thymeleaf,
         * ThymeleafProperties默认了prefix为classpath:/templates/, suffix为.html
         * 即classpath:/templates/success.html
         */
        map.put("hello", "<h1>zth</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        return "success";
    }

    @RequestMapping({"/", "login.html"})
    public String index(){
        return "login";
    }
}