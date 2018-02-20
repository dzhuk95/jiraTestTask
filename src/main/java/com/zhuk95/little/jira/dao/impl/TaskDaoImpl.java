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
import java.util.Optional;

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
    public void saveOrUpdate(List<UserTaskEntity> taskEntity) {
        userTaskRepository.save(taskEntity);
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

    @Override
    public Optional<UserTaskEntity> getByUserIdAndTaskId(int userId, int taskId) {
        return userTaskRepository.findByUserIdAndTaskId(userId, taskId);
    }
}
