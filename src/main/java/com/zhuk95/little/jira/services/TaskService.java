package com.zhuk95.little.jira.services;


import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity createTask(CreateTaskReq createTaskReq);

    ResponseEntity updateTask();

    ResponseEntity getTask();

}
