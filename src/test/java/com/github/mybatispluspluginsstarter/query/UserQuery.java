package com.github.mybatispluspluginsstarter.query;

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
public class UserQuery extends BaseQuery {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

}
