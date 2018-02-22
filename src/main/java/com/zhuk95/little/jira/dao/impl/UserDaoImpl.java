package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.dao.repository.UserRepository;
import com.zhuk95.little.jira.dao.repository.UserTaskRepository;
import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.getAllUser();
    }

    @Override
    @Transactional
    @Modifying
    public boolean saveOrUpdate(UserEntity user) {
        return userRepository.save(user).getId() != null;
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserEntity> getByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<UserEntity> findAllById(List<Integer> ids) {
        return userRepository.findById(ids);
    }
}
