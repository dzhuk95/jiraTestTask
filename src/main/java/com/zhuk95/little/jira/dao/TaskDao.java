package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.TaskEntity;

import java.util.List;

public interface TaskDao {

    List<TaskEntity> getAllForProject(ProjectEntity projectEntity);

    boolean saveOrUpdate(TaskEntity task);

    void deleteTask(TaskEntity task);

}
