package com.obroom.smartjump.module1.controller;

import com.obroom.smartjump.module1.entity.UserEntity;
import com.obroom.smartjump.module1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("getUsers")
    public List<UserEntity> getUsers() {
        logger.info("获取用户数据");
        List<UserEntity> list = userService.getUsers();
        System.out.println(list.size());
        return list;
    }

    @GetMapping("getById")
    public UserEntity getById(Integer id) {
        logger.info("获取用户数据");
        UserEntity user = userService.getById(id);
        return user;
    }
}