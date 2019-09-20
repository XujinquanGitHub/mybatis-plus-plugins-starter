package com.github.mybatispluspluginsstarter.model;

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