package com.zhuk95.little.jira.services;


import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import com.zhuk95.little.jira.models.api.req.UpdateTaskReq;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity createTask(CreateTaskReq createTaskReq);

    ResponseEntity updateTask(UpdateTaskReq updateTaskReq);

    ResponseEntity getTask(int id);

}
