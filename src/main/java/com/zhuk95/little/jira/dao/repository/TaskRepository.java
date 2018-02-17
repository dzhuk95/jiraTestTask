package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
}
