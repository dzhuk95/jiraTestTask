package com.zhuk95.little.jira.models.api.req;

import java.util.List;

public class AddUserToProjectReq {
    private int projectId;
    private List<Integer> ids;

    public AddUserToProjectReq() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
