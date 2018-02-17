package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getAll();

    boolean saveOrUpdate(UserEntity user);
}
