package com.zhuk95.little.jira.models.api.req;

public class CreateCommentReq {
    private int taskId;
    private String text;

    public CreateCommentReq() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
