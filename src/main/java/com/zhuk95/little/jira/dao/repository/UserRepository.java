package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
