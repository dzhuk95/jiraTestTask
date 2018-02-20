package com.zhuk95.little.jira.models.api.req;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateProjectReq {
    @NotNull(message = "Project name must not be null")
    private String name;
    private List<Integer> userIds;

    public CreateProjectReq() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
