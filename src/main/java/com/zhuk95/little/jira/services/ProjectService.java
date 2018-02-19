package com.zhuk95.little.jira.services;

import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import org.springframework.http.ResponseEntity;

public interface ProjectService {

    ResponseEntity getProjects();

    ResponseEntity getProjectsForUser();

    ResponseEntity createProject(CreateProjectReq createProjectReq);

    ResponseEntity addDeveloperToProject(AddUserToProjectReq addUserToProjectReq);
}
