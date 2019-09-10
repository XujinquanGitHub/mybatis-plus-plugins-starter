package com.github.mybatispluspluginsstarter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xujinquan
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    /**
     * 基本对象的属性名
     */
    String propName() default "";

    /**
     * 查询方式
     */
    Type type() default Type.EQUAL;


    /*
     是否忽略空字符串值
     */
    boolean ignoreString() default true;


    enum Type {
        /**
         * 相等
         */
        EQUAL
        /**  大于等于 */
        , GREATER_THAN
        /**  小于等于 */
        , LESS_THAN
        /**  中模糊查询 */
        , INNER_LIKE
        /**  左模糊查询 */
        , LEFT_LIKE
        /**  右模糊查询 */
        , RIGHT_LIKE
        /**  小于 */
        , LESS_THAN_NQ
        //**  包含 */
        , IN
        //**  多字段模糊查询 */
        , MULTI_FIELD_LIKE
    }

}

