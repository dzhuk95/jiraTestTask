package com.zhuk95.little.jira.models.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_task")
public class UserTaskEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserTaskEntity() {
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
