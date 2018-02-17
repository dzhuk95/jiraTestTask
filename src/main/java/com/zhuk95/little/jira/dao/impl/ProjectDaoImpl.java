package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.repository.ProjectRepository;
import com.zhuk95.little.jira.dao.repository.ProjectUserRepository;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectUserRepository projectUserRepository;

    @Override
    public List<ProjectEntity> getAll() {
        return null;
    }

    @Override
    public List<ProjectEntity> getAllByUser(UserEntity userEntity) {
        return null;
    }
}
