package com.zhuk95.little.jira.models.api.req;

import com.zhuk95.little.jira.models.enums.TaskStatus;

public class UpdateTaskReq extends CreateTaskReq {
    private int taskId;
    private TaskStatus taskStatus;

    public UpdateTaskReq() {
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
