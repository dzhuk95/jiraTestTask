package com.zhuk95.little.jira.models.api.req;

import javax.validation.constraints.NotNull;

public class CreateTaskReq {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer[] developers;

    public CreateTaskReq() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(Integer[] developers) {
        this.developers = developers;
    }
}
