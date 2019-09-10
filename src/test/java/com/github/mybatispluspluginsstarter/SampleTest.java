package com.github.mybatispluspluginsstarter;

import com.github.mybatispluspluginsstarter.mapper.UserMapper;
import com.github.mybatispluspluginsstarter.model.User;
import com.github.mybatispluspluginsstarter.query.UserQuery;
import com.github.mybatispluspluginsstarter.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: mybatis-plus-plugins-starter
 * @description:
 * @author: 许金泉
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusPluginsStarterApplication.class)
public class SampleTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userService.list(new UserQuery().setName("J"));
        Assert.assertEquals(2, userList.size());
        userList.forEach(System.out::println);
    }
}
