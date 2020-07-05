package com.obroom.plugin.smartjump.module1.service;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    UserEntity getById(Integer id);

    int querySql(String name);

    void batchInsert();
}
