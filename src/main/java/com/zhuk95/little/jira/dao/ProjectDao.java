package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;

import java.util.List;

public interface ProjectDao {

    List<ProjectEntity> getAll();

    List<ProjectEntity> getAllByUser(UserEntity userEntity);
}
