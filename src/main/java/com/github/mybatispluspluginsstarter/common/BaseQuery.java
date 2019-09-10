package com.github.mybatispluspluginsstarter.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
@Data
@Accessors(chain = true)
public class BaseQuery {

    @TableField(exist = false)
    private long size = 10;

    @TableField(exist = false)
    private long current = 1;

    /**
     * SQL 排序 ASC 数组
     */
    @TableField(exist = false)
    private List<String> ascs;
    /**
     * SQL 排序 DESC 数组
     */
    @TableField(exist = false)
    private List<String> descs;

    public IPage getPage() {

        Page page = new Page(current, size);
        page.setAscs(ascs);
        page.setDescs(descs);
        return page;
    }

}
