package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.repository.ProjectRepository;
import com.zhuk95.little.jira.dao.repository.ProjectUserRepository;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectUserRepository projectUserRepository;

    @Override
    public Page<ProjectUserEntity> getAllByUser(int userId, Pageable pageable) {
        return projectUserRepository.getByUserId(userId, pageable);
    }

    @Override
    public Page<ProjectEntity> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Optional<ProjectEntity> getById(int id) {
        return projectRepository.getById(id);
    }

    @Override
    public ProjectEntity saveOrUpdate(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    @Override
    public void saveOrUpdate(List<ProjectUserEntity> userProjectList) {
        projectUserRepository.save(userProjectList);
    }
}
