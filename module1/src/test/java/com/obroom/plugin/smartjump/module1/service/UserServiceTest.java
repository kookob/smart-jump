package com.obroom.plugin.smartjump.module1.service;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

//@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
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
}