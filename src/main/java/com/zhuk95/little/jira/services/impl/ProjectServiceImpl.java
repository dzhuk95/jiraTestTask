package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;

    @Override
    public ResponseEntity getProjects() {
        int userId = 1;
        projectDao.getAllByUser(userId);
        return null;
    }

    @Override
    public ResponseEntity createProject() {
        return null;
    }

    @Override
    public ResponseEntity addDeveloperToProject() {
        return null;
    }
}
