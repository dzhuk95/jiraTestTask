package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;

import java.util.List;

public interface ProjectDao {

    List<ProjectEntity> getAllByUser(int userId);

    List<ProjectEntity> getAll();

    ProjectEntity getById(int id);

    ProjectEntity saveOrUpdate(ProjectEntity projectEntity);

    void saveOrUpdate(List<ProjectUserEntity> userProjectList);

}
