package com.github.mybatispluspluginsstarter.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mybatispluspluginsstarter.common.BaseQuery;
import com.github.mybatispluspluginsstarter.common.util.QueryHelp;
import com.github.mybatispluspluginsstarter.mapper.MyBaseMapper;

import java.util.List;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: xujinquan
 **/
public class BaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {


    @Override
    public <M extends BaseQuery> IPage<M> pageByBaseRequest(M m) {
        return page(m.getPage(), QueryHelp.getPredicate(m));
    }

    @Override
    public List<T> list(Object m) {
        return list(QueryHelp.getPredicate(m));
    }
}
