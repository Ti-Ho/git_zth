package com.zth.springboot.mapper;

import com.zth.springboot.bean.Users;
import org.apache.ibatis.annotations.*;

/**
 * @author Kai
 * @date 2020/4/17 16:31
 */


public interface UsersMapper {
    /**
     * 1. 插入一个用户
     * @param user
     * @return
     */
    @Insert("INSERT INTO users (username,password,phone) VALUES (#{username}, #{password}, #{phone})")
    public int insertUser(Users user);

    /**
     * 2. 根据ID删除一个用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteUserById(Integer id);

    /**
     * 3. 根据ID修改用户
     * @param user
     * @return
     */
    @Update("UPDATE users set username = #{username}, password = #{password}, phone = #{phone} where id = #{id}")
    public int updateUser(Users user);


    /**
     * 4. 根据ID查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM users WHERE id = #{id}")
    public Users queryUserById(Integer id);
}
