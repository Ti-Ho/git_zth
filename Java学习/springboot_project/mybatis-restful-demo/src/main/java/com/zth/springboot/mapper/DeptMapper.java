package com.zth.springboot.mapper;

import com.zth.springboot.bean.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Kai
 * @date 2020/4/17 19:33
 */

public interface DeptMapper {
    //@Insert("INSERT INTO users (username,password,phone) VALUES (#{username}, #{password}, #{phone})")
    @Insert("INSERT INTO dept (deptname) VALUES (#{deptName})")
    public Integer insertDept(Dept dept);

    @Select("SELECT * FROM dept where id = #{id}")
    public Dept selectDeptById(Integer id);
}
