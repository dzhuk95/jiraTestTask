package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.repository.ProjectRepository;
import com.zhuk95.little.jira.dao.repository.ProjectUserRepository;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
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
    public List<ProjectEntity> getAllByUser(int userId) {
        return null;
    }

    @Override
    public ProjectEntity saveOrUpdate(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    @Override
    public void addUserToProject(List<ProjectUserEntity> projectUserEntities) {
        projectUserRepository.save(projectUserEntities);
    }
}
