package com.github.mybatispluspluginsstarter.common.util;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.mybatispluspluginsstarter.annotation.Query;
import com.github.mybatispluspluginsstarter.common.BaseQuery;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author xujinquan
 * @date 2019-6-4 14:59:48
 */
@Slf4j
public class QueryHelp {

    /**
     * @author :  xujinquan
     */
    @SuppressWarnings("unchecked")
    public static QueryWrapper getPredicate(Object query) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (query == null) {
            return queryWrapper;
        }
        try {
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                Query q = field.getAnnotation(Query.class);
                if (q == null) {
                    continue;
                }
                String propName = q.propName();
                String attributeName = StringUtils.isEmpty(propName) ? field.getName() : propName;
                Object val = field.get(query);
                if (val == null) {
                    continue;
                }
                boolean ignoreString = q.ignoreString();
                if (ignoreString && val instanceof String && StringUtils.isEmpty(val.toString())) {
                    continue;
                }
                switch (q.type()) {
                    case EQUAL:
                        queryWrapper.eq(attributeName, val.toString());
                        break;
                    case GREATER_THAN:
                        queryWrapper.ge(attributeName, val.toString());
                        break;
                    case LESS_THAN:
                        queryWrapper.le(attributeName, val.toString());
                        break;
                    case LESS_THAN_NQ:
                        queryWrapper.lt(attributeName, val.toString());
                        break;
                    case INNER_LIKE:
                        queryWrapper.like(attributeName, val.toString());
                        break;
                    case LEFT_LIKE:
                        queryWrapper.likeLeft(attributeName, val.toString());
                        break;
                    case RIGHT_LIKE:
                        queryWrapper.likeRight(attributeName, val.toString());
                        break;
                    case IN:
                        if (val instanceof Collection && CollectionUtils.isEmpty((Collection) val)) {
                            queryWrapper.in(attributeName, (Collection) val);
                        }
                        break;
                    case MULTI_FIELD_LIKE:
                        String[] attrs = attributeName.split(",");
                        final Object value = val;
                        queryWrapper.and(u -> {
                            QueryWrapper childrenQuery = (QueryWrapper) u;
                            for (int index = 0; index < attrs.length; index++) {
                                String attr = attrs[index];
                                childrenQuery.or(true).like(attr, value.toString());
                            }
                        });
                        break;
                    default:
                        break;
                }
                field.setAccessible(accessible);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return queryWrapper;
    }

    @SuppressWarnings("unchecked")
    public static List<Field> getAllFields(Class clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields;
    }
}
