package com.obroom.plugin.smartjump.module1.controller;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;
import com.obroom.plugin.smartjump.module1.service.UserService;
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
        logger.info("get users");
        List<UserEntity> list = userService.getUsers();
        System.out.println(list.size());
        return list;
    }

    @GetMapping("getById")
    public UserEntity getById(Integer id) {
        logger.info("get user by id");
        UserEntity user = userService.getById(id);
        return user;
    }

    @GetMapping("batchInsert")
    public String batchInsert() {
        logger.info("batch insert user test");
        userService.batchInsert(null);
        return "success";
    }
}