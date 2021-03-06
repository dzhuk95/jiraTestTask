package com.zhuk95.little.jira.models.entities;

import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import com.zhuk95.little.jira.models.api.req.UpdateTaskReq;
import com.zhuk95.little.jira.models.enums.TaskStatus;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class TaskEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "project_id")
    @Fetch(FetchMode.JOIN)
    private ProjectEntity project;

    @Enumerated
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.MERGE)
    private List<CommentEntity> comments;

    public TaskEntity() {
    }

    private TaskEntity(String name, String description, ProjectEntity project, TaskStatus taskStatus) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.taskStatus = taskStatus;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public static TaskEntity of(CreateTaskReq createTaskReq, ProjectEntity entity) {
        return new TaskEntity(createTaskReq.getName(), createTaskReq.getDescription(), entity, TaskStatus.WAITIN);
    }

    public void update(UpdateTaskReq updateTaskReq) {
        this.description = updateTaskReq.getDescription() == null ? this.description : updateTaskReq.getDescription();
        this.name = updateTaskReq.getName() == null ? this.name : updateTaskReq.getName();
        this.taskStatus = updateTaskReq.getTaskStatus() == null ? this.taskStatus : updateTaskReq.getTaskStatus();
    }
}
