package com.github.mybatispluspluginsstarter.service;

import com.github.mybatispluspluginsstarter.mapper.UserMapper;
import com.github.mybatispluspluginsstarter.model.User;
import org.springframework.stereotype.Service;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 * @create: 2019-09-10 16:17
 **/
@Service
public class UserService extends BaseServiceImpl<UserMapper, User> {
}
