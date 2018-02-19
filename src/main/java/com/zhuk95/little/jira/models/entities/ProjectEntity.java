package com.zhuk95.little.jira.models.entities;

import com.zhuk95.little.jira.models.api.req.CreateProjectReq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class ProjectEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    public ProjectEntity() {
    }

    private ProjectEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProjectEntity of(CreateProjectReq createProjectReq) {
        return new ProjectEntity(createProjectReq.getName());
    }
}
