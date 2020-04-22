package com.zth.mapper;

/**
 * @author Kai
 * @date 2020/4/21 17:04
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zth.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 相当于DAO层
 * 在对应的Mapper上面继承基本的类BaseMapper
 */
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD操作都已经编写完成了
}
