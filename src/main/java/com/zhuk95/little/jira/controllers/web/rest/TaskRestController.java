package com.zhuk95.little.jira.controllers.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO add logic
@RestController
@RequestMapping(value = "api/tasks", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskRestController {

    @Autowired
    TaskRestController taskRestController;

    @GetMapping
    public ResponseEntity getTask() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createTask() {
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateTask() {
        return ResponseEntity.ok().build();
    }
}
