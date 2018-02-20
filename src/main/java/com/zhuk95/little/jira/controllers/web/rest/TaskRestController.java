package com.zhuk95.little.jira.controllers.web.rest;

import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import com.zhuk95.little.jira.models.api.req.UpdateTaskReq;
import com.zhuk95.little.jira.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/tasks", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity getTask(@RequestParam int taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createTask(@RequestBody @Validated CreateTaskReq createTaskReq) {
        return taskService.createTask(createTaskReq);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateTask(@RequestBody @Validated UpdateTaskReq UpdateTaskReq) {
        return taskService.updateTask(UpdateTaskReq);
    }
}
