package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.TaskDao;
import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.models.AuthorizedUser;
import com.zhuk95.little.jira.models.api.ResponseWrapper;
import com.zhuk95.little.jira.models.api.req.CreateTaskReq;
import com.zhuk95.little.jira.models.api.req.UpdateTaskReq;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.TaskEntity;
import com.zhuk95.little.jira.models.entities.UserTaskEntity;
import com.zhuk95.little.jira.models.enums.ResponseStatus;
import com.zhuk95.little.jira.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;
    @Autowired
    ProjectDao projectDao;
    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity createTask(CreateTaskReq createTaskReq) {
        ProjectEntity pe = projectDao.getById(createTaskReq.getProjectId());
        if (pe == null) throw new IllegalArgumentException("Project is not exist");
        TaskEntity taskEntity = TaskEntity.of(createTaskReq, pe);

        List<Integer> developers = createTaskReq.getDevelopers() == null ? new ArrayList<>() : createTaskReq.getDevelopers();
        if (developers.isEmpty())
            developers.add(AuthorizedUser.id());
        taskDao.saveOrUpdate(userDao.findAllById(developers).stream()
                .map(item -> UserTaskEntity.of(taskEntity, item)).collect(Collectors.toList()));
        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }

    @Override
    public ResponseEntity updateTask(UpdateTaskReq updateTaskReq) {
        TaskEntity te = taskDao.get(updateTaskReq.getTaskId());
        te.update(updateTaskReq);
        taskDao.saveOrUpdate(te);
        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }

    @Override
    public ResponseEntity getTask(int id) {
        Optional<UserTaskEntity> ute = taskDao.getByUserIdAndTaskId(AuthorizedUser.id(), id);
        if (ute.isPresent())
            return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS, null, ute.get().getTask()));
        return  ResponseEntity.notFound().build();
    }


}
