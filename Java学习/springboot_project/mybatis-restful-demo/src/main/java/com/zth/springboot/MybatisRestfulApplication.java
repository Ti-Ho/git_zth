package com.zth.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.zth.springboot.mapper")
@SpringBootApplication
public class MybatisRestfulApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisRestfulApplication.class, args);
    }
}
