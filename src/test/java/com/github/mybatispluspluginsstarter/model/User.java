package com.github.mybatispluspluginsstarter.model;

import com.github.mybatispluspluginsstarter.annotation.Query;
import com.github.mybatispluspluginsstarter.common.BaseQuery;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
@Data
@Accessors(chain = true)
public class User  {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}