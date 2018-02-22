package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<UserEntity> getAll();

    boolean saveOrUpdate(UserEntity user);

    UserEntity getByEmail(String email);

    Optional<UserEntity> getByEmailAndPassword(String email, String password);

    List<UserEntity> findAllById(List<Integer> ids);
}
