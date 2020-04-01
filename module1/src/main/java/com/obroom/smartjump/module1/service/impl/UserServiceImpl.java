package com.obroom.smartjump.module1.service.impl;

import com.obroom.smartjump.module1.entity.UserEntity;
import com.obroom.smartjump.module1.mapper.UserMapper;
import com.obroom.smartjump.module1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
