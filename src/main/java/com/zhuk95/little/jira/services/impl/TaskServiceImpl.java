package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import com.zhuk95.little.jira.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//Todo
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Override
    public ResponseEntity createTask(CreateTaskReq createTaskReq) {
        return null;
    }

    @Override
    public ResponseEntity updateTask() {
        return null;
    }

    @Override
    public ResponseEntity getTask() {
        return null;
    }
}
