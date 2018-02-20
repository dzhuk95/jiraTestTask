package com.zhuk95.little.jira.models.api.req;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateTaskReq {
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Description must not be null")
    private String description;
    @NotNull(message = "Project id must not be null")
    private Integer projectId;
    private List<Integer> developers;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<Integer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Integer> developers) {
        this.developers = developers;
    }
}
