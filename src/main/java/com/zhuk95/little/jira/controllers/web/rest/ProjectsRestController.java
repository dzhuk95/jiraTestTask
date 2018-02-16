package com.zhuk95.little.jira.controllers.web.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/projects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectsRestController {

    @GetMapping("all")
    public ResponseEntity getAllProjectsForUser() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getProjectsForUser() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createProject(){
        return ResponseEntity.ok().build();
    }
}
