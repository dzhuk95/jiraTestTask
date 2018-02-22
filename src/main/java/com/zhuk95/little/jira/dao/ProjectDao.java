package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    Page<ProjectUserEntity> getAllByUser(int userId, Pageable pageable);

    Page<ProjectEntity> getAll(Pageable pageable);

    Optional<ProjectEntity> getById(int id);

    ProjectEntity saveOrUpdate(ProjectEntity projectEntity);

    void saveOrUpdate(List<ProjectUserEntity> userProjectList);

}
