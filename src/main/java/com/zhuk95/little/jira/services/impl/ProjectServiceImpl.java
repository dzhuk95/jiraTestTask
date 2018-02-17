package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ResponseEntity getProjects() {
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
