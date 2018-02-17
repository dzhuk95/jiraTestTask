package com.zhuk95.little.jira.services;


import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity createTask();

    ResponseEntity updateTask();

    ResponseEntity getTask();

}
