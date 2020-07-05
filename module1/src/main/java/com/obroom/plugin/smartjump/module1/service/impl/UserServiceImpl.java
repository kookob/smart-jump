package com.obroom.plugin.smartjump.module1.service.impl;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;
import com.obroom.plugin.smartjump.module1.mapper.UserMapper;
import com.obroom.plugin.smartjump.module1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public UserEntity getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public int querySql(String name) {
        return userMapper.querySql(name);
    }

    @Override
    public void batchInsert() {
        List<UserEntity> userList = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setName("user1");
        user1.setAge(21);
        UserEntity user2 = new UserEntity();
        user2.setName("user2");
        user2.setAge(22);
        UserEntity user3 = new UserEntity();
        user3.setName("user3");
        user3.setAge(23);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userMapper.batchInsert(userList);
    }
}
