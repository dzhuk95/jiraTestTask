package com.zhuk95.little.jira.controllers.web.rest;

import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import com.zhuk95.little.jira.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/projects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectsRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("all")
    public ResponseEntity getAll() {
        return projectService.getProjects();
    }

    @GetMapping
    public ResponseEntity getProjectsForUser() {
        return projectService.getProjectsForUser();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createProject(@RequestBody CreateProjectReq createProjectReq) {
        return projectService.createProject(createProjectReq);
    }

    @PostMapping(value = "user/add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addUserToProject(@RequestBody AddUserToProjectReq addUserToProjectReq) {
        return projectService.addDeveloperToProject(addUserToProjectReq);
    }
}
