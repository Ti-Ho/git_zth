package com.zth.module.service.impl;

import com.zth.module.pojo.User;
import com.zth.module.mapper.UserMapper;
import com.zth.module.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zth
 * @since 2020-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
