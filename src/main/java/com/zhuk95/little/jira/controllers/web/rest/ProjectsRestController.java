package com.zhuk95.little.jira.controllers.web.rest;

import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import com.zhuk95.little.jira.models.api.req.GridReq;
import com.zhuk95.little.jira.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectsRestController {
    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "all", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAll(@RequestBody GridReq gridReq) {
        return projectService.getProjects(gridReq);
    }

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getProjectsForUser(@RequestBody GridReq gridReq) {
        return projectService.getProjectsForUser(gridReq);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createProject(@RequestBody @Validated CreateProjectReq createProjectReq) {
        return projectService.createProject(createProjectReq);
    }

    @PostMapping(value = "user/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addUserToProject(@RequestBody AddUserToProjectReq addUserToProjectReq) {
        return projectService.addDeveloperToProject(addUserToProjectReq);
    }
}
