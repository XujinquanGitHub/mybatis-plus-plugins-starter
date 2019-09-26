package com.github.mybatispluspluginsstarter.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mybatispluspluginsstarter.common.BaseQuery;
import com.github.mybatispluspluginsstarter.common.util.QueryHelp;
import com.github.mybatispluspluginsstarter.common.util.ReflectionUtil;
import com.github.mybatispluspluginsstarter.mapper.MyBaseMapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: xujinquan
 **/
public class BaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {


    @Override
    public <M extends BaseQuery> IPage<T> pageByBaseRequest(M m) {
        Class aClass = ReflectionUtil.getClass(this.getClass(), 1);
        List<Field> allFields = ReflectionUtil.getAllFields(aClass);
        m.setAllowOrderField(allFields.stream().map(u -> u.getName()).collect(Collectors.toSet()));
        return page(m.getPage(), QueryHelp.getPredicate(m));
    }

    @Override
    public List<T> list(Object m) {
        return list(QueryHelp.getPredicate(m));
    }
}
