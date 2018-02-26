package com.zhuk95.little.jira.models.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_user")
public class ProjectUserEntity extends BaseEntity {
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ProjectUserEntity() {
    }

    public ProjectUserEntity(ProjectEntity project, UserEntity user) {
        this.project = project;
        this.user = user;
    }

    public static ProjectUserEntity of(UserEntity userEntity, ProjectEntity projectEntity) {
        return new ProjectUserEntity(projectEntity, userEntity);
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
