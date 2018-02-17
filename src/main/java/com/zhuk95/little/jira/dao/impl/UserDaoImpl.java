package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.dao.repository.UserRepository;
import com.zhuk95.little.jira.dao.repository.UserTaskRepository;
import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public boolean saveOrUpdate(UserEntity user) {
        return false;
    }
}
