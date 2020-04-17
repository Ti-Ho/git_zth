package com.zth.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Kai
 * @date 2020/4/17 9:29
 */

/**
 * 使用WebMvcConfigurer可有扩展SpringMVC的功能
 * 既保留了所有MVC的自动配置，也能用我们扩展的配置
 */

//@EnableWebMvc   //放弃SpringBoot对MVC的自动配置 全面接管MVC配置
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //效果：浏览器发送 /zth 请求 也来到 success 页面
        registry.addViewController("/kaikai").setViewName("success");
    }
}
