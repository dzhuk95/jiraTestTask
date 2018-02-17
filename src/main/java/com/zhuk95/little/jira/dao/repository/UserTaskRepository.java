package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTaskEntity,Integer> {
}
