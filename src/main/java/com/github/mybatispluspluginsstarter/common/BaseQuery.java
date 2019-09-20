package com.github.mybatispluspluginsstarter.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.mybatispluspluginsstarter.common.util.StringUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private Set<String> allowOrderField = new HashSet<>();

    public Set<String> getAllowOrderField() {
        return allowOrderField;
    }

    public void setAllowOrderField(Set<String> allowOrderField) {
        this.allowOrderField = allowOrderField;
    }


    public IPage getPage() {
        Page page = new Page(current, size);
        if (ascs != null && ascs.size() > 0) {
            page.addOrder(ascs.stream().map(u -> new OrderItem().setColumn(u).setAsc(true)).toArray(s -> new OrderItem[s]));
        }
        if (descs != null && descs.size() > 0) {
            page.addOrder(descs.stream().map(u -> new OrderItem().setColumn(u).setAsc(false)).toArray(s -> new OrderItem[s]));
        }
        if (page.getOrders() == null || page.getOrders().size() == 0) {
            page.addOrder(QueryConfig.defaultOrderItems.stream().toArray(s -> new OrderItem[s]));
        }
        Set<String> allowOrderField = getAllowOrderField();
        if (allowOrderField != null && allowOrderField.size() > 0) {
            List<OrderItem> orders = page.getOrders();
            orders = orders.stream().filter(u -> allowOrderField.contains(StringUtil.underlineToHump(u.getColumn()))).collect(Collectors.toList());
            if (QueryConfig.isHump) {
                orders.forEach(item -> {
                    item.setColumn(StringUtil.humpToUnderline(item.getColumn()));
                });
            }
            page.setOrders(orders);

        }
        return page;
    }

}
