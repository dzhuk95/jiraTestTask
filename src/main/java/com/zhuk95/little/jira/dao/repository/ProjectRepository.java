package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {
}
