package com.github.mybatispluspluginsstarter.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.mybatispluspluginsstarter.common.BaseQuery;

import java.util.List;

public interface IBaseService<T> extends IService<T> {

    <M extends BaseQuery> IPage<M> pageByBaseRequest(M m);

    <M extends BaseQuery> List<T> list(M m);
}
