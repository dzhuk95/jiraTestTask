package com.zhuk95.little.jira.services;

import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import com.zhuk95.little.jira.models.api.req.GridReq;
import org.springframework.http.ResponseEntity;

public interface ProjectService {

    ResponseEntity getProjects(GridReq gridReq);

    ResponseEntity getProjectsForUser(GridReq gridReq);

    ResponseEntity createProject(CreateProjectReq createProjectReq);

    ResponseEntity addDeveloperToProject(AddUserToProjectReq addUserToProjectReq);
}
