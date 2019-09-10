package com.github.mybatispluspluginsstarter.mapper;

import com.github.mybatispluspluginsstarter.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
@Mapper
public interface UserMapper extends MyBaseMapper<User> {
}
