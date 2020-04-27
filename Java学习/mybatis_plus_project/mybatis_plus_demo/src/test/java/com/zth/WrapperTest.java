package com.zth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zth.mapper.UserMapper;
import com.zth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author Kai
 * @date 2020/4/22 22:25
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //查询name不为空，并且邮箱不为空的用户，年龄大于12岁
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2(){
        // 查询名字zth
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "zth");
        User user = userMapper.selectOne(wrapper);  // 查询一个数据， 出现多个结果使用List或Map
        System.out.println(user);
    }

    @Test
    void test3(){
        // 查询年龄在 20~30岁的用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.between("age", 20, 30); //区间
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //模糊查询
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper
                .notLike("name", "e")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
}
