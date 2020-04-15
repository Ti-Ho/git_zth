package com.zth.springboot;

import com.zth.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot的单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@SpringBootTest
class SpringBootInitializrHelloworldApplicationTests {
    @Autowired
    Person p;
    @Test
    void contextLoads() {
        System.out.println(p);
    }
}
