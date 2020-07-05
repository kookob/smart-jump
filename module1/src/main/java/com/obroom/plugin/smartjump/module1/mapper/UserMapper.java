package com.obroom.plugin.smartjump.module1.mapper;

import com.obroom.plugin.smartjump.module1.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserEntity> getUsers();

    UserEntity getById(Integer id);

    int querySql(String name);

    void batchInsert(List<UserEntity> userList);
}

