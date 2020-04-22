package com.zth;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zth.mapper.UserMapper;
import com.zth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    // 继承了BaseMapper 所有的方法都来自于父类，
    // 我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //查询全部用户
        //参数是一个Wrapper 条件构造器
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //测试插入
    @Test
    void testInsertUSer(){
        User user = new User();
        user.setName("zth");
        user.setAge(21);
        user.setEmail("kai");

        int result = userMapper.insert(user);   //帮我们自动生成id
        System.out.println(result);             // 输出： 1   （受影响的行数）
        System.out.println("user = " + user);   //输出：user = User(id=1252532505785446401, name=zth, age=21, email=kai)
    }

    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(4L);
        user.setName("updated name");
        user.setAge(199);
        // 注意 updateById 但是参数是一个对象
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    //测试乐观锁成功 (单线程)
    @Test
    public void testOptimisticLocker(){
        //1. 查询用户信息
        User user = userMapper.selectById(1L);
        //2. 修改用户信息
        user.setName("kai");
        user.setEmail("990211");
        //3. 执行更新操作
        userMapper.updateById(user);
    }

    //测试乐观锁失败 多线程下
    @Test
    public void testOptimisticLocker2(){
        //线程A
        User user = userMapper.selectById(1L);
        user.setName("kai");
        user.setEmail("990211");

        // 模拟另一个线程B执行了插队操作
        User user2 = userMapper.selectById(1L);
        user.setName("kai222");
        user.setEmail("9902112222");
        userMapper.updateById(user2);

        userMapper.updateById(user); //线程A更新 如果没有乐观锁就会覆盖插队线程B的值
    }

    //测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> ul = userMapper.selectBatchIds(Arrays.asList(3));
        ul.forEach(System.out::println);
    }

    // 按条件查询之一 使用map操作
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zth");
        map.put("age", 21);

        List<User> ul = userMapper.selectByMap(map);
        ul.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> userpage = new Page<>(2, 5); //查询第一页 的五个数据
        userMapper.selectPage(userpage, null);

        userpage.getRecords().forEach(System.out::println);
        System.out.println("数据库中的数据总条数" + userpage.getTotal());
    }

    //测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(3L);
    }

    //批量id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1,2));
    }

    //通过map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        userMapper.deleteByMap(map);
    }
}
