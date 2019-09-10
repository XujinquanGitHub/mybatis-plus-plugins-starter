package com.github.mybatispluspluginsstarter.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author xujinquan
 * @date 2019/5/22 17:14
 */
@Configuration
public class MyBatisConfig {


    @Bean
    public ISqlInjector sqlInjector() {

        return new DefaultSqlInjector() {
            /**
             * 注入自定义全局方法
             */
            @Override
            public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
                List<AbstractMethod> methodList = super.getMethodList(mapperClass);
                methodList.add(new LogicDeleteByIdWithFill());
                return methodList;
            }
        };

    }

}


