package com.zhuk95.little.jira.models.api.req;

import javax.validation.constraints.NotNull;

public class AddCommentReq {
    @NotNull
    private int taskId;
    @NotNull
    private String text;

    public AddCommentReq() {
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
