package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.TaskEntity;
import com.zhuk95.little.jira.models.entities.UserTaskEntity;

import java.util.List;

public interface TaskDao {

    List<UserTaskEntity> getAllForProject(ProjectEntity projectEntity);

    boolean saveOrUpdate(TaskEntity task);

    void deleteTask(TaskEntity task);

    TaskEntity get(int id);

}
