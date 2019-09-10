package com.github.mybatispluspluginsstarter.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
public class BaseQuery {

    private long size = 10;

    private long current = 1;

    /**
     * SQL 排序 ASC 数组
     */
    private List<String> ascs;
    /**
     * SQL 排序 DESC 数组
     */
    private List<String> descs;

    public IPage getPage() {

        Page page = new Page(current, size);
        page.setAscs(ascs);
        page.setDescs(descs);
        return page;
    }

}
