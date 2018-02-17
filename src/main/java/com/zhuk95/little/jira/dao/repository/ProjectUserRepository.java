package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity,Integer> {
}
