package com.zhuk95.little.jira.services;

import org.springframework.http.ResponseEntity;

public interface ProjectService {

    ResponseEntity getProjects();

    ResponseEntity createProject();

    ResponseEntity addDeveloperToProject();
}
