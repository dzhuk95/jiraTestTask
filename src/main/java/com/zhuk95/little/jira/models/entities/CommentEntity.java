package com.zhuk95.little.jira.models.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "task_id")
    @Fetch(FetchMode.JOIN)
    private TaskEntity taskEntity;

    public CommentEntity() {
    }

    private CommentEntity(String text, TaskEntity taskEntity) {
        this.text = text;
        this.taskEntity = taskEntity;
    }

    public static CommentEntity of(String text, TaskEntity taskEntity) {
        return new CommentEntity(text, taskEntity);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
