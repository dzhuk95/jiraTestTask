package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.TaskDao;
import com.zhuk95.little.jira.dao.repository.TaskRepository;
import com.zhuk95.little.jira.dao.repository.UserTaskRepository;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.TaskEntity;
import com.zhuk95.little.jira.models.entities.UserTaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserTaskRepository userTaskRepository;

    @Override
    public List<UserTaskEntity> getAllForProject(ProjectEntity projectEntity) {
        return userTaskRepository.getAllTask(projectEntity.getId());
    }

    @Override
    @Transactional
    @Modifying
    public boolean saveOrUpdate(TaskEntity task) {
        return taskRepository.save(task).getId() != null;
    }

    @Override
    @Transactional
    @Modifying
    public void deleteTask(TaskEntity task) {
        taskRepository.delete(task);
    }

    @Override
    public TaskEntity get(int id) {
        return taskRepository.findOne(id);
    }
}
