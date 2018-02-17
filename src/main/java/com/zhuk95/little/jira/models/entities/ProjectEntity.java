package com.zhuk95.little.jira.models.entities;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
