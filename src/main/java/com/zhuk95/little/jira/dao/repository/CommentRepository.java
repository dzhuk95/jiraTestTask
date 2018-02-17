package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
