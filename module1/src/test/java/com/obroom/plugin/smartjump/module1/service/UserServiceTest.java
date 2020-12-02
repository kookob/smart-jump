package com.obroom.plugin.smartjump.module1.service;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 分析原因：因为项目是springboot+dubbo架构，dao项目依赖于pojo项目，在pojo项目中也有启动类@SpringBootApplication，
 * 因为在dao的测试类中启动方法时，会加载pojo项目启动类，所以会造成上图所示错误，注释掉pojo项目启动类上的@SpringBootApplication注解即可。
 */
//@SpringBootConfiguration
//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired(required = false)
    private UserService userService;

    @Test
    void getUsers() {
        List<UserEntity> userList = userService.getUsers();
        Assert.notNull(userList, "user list");
    }

    @Test
    void getById() {
        UserEntity user = userService.getById(1);
        UserEntity user2 = userService.getById(2);
        Assert.notNull(user, "user is null");
    }

    @Test
    void querySql() {
        userService.querySql("world");
        Assert.notNull("user", "user is null");
    }

    @Test
    void selectDemo1() {
        userService.selectDemo1("hello\nworld\nhello\tworld\nbest");
        Assert.notNull("user", "user is null");
    }
}
