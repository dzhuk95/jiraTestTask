package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.TaskDao;
import com.zhuk95.little.jira.dao.repository.TaskRepository;
import com.zhuk95.little.jira.dao.repository.UserTaskRepository;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserTaskRepository userTaskRepository;

    @Override
    public List<TaskEntity> getAllForProject(ProjectEntity projectEntity) {
        return null;
    }

    @Override
    public boolean saveOrUpdate(TaskEntity task) {
        return false;
    }

    @Override
    public void deleteTask(TaskEntity task) {

    }
}
