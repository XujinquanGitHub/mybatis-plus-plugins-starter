package com.github.mybatispluspluginsstarter.common;

import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
public class QueryConfig {

    public static boolean isHump = true;

    public static List<OrderItem> defaultOrderItems = new ArrayList<>();

    static {
        defaultOrderItems.add(new OrderItem().setColumn("createDate").setAsc(false));
    }

}
