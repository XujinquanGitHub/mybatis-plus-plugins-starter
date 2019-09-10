package com.github.mybatispluspluginsstarter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: xujinquan
 **/
public interface MyBaseMapper<T> extends BaseMapper<T> {

    int deleteByIdWithFill(T entity);

}
