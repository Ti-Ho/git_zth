package com.zth.springboot.controller;

import com.zth.springboot.bean.Dept;
import com.zth.springboot.bean.Users;
import com.zth.springboot.mapper.DeptMapper;
import com.zth.springboot.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kai
 * @date 2020/4/17 16:54
 */

@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    DeptMapper deptMapper;

    /**
     * 新增一个用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    public Users insertUser(Users user) {
        usersMapper.insertUser(user);
        return user;
    }

    /**
     * 修改一个用户
     * @param user
     * @return
     */
    @PutMapping("/user")
    public int updateUser(Users user){
        return usersMapper.updateUser(user);
    }


    /**
     * 删除一个用户
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable Integer id){
        return usersMapper.deleteUserById(id);
    }

    /**
     * 按照id查找一个User
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Users selectUserById(@PathVariable Integer id){
        return usersMapper.queryUserById(id);
    }

    /**
     * 插入一个部门
     * @param dept
     * @return
     */
    @PostMapping("/dept")
    public Dept insertDept(Dept dept) {
        System.out.println("dept = " + dept.getDeptName());
        deptMapper.insertDept(dept);
        return dept;
    }

    @GetMapping("/dept/{id}")
    public Dept selectDeptById(@PathVariable Integer id){
        return deptMapper.selectDeptById(id);
    }

}
