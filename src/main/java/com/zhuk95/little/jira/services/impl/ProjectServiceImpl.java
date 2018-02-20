package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.models.api.ResponseWrapper;
import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.models.AuthorizedUser;
import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import com.zhuk95.little.jira.models.api.resp.ListResp;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;
import com.zhuk95.little.jira.models.enums.ResponseStatus;
import com.zhuk95.little.jira.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity getProjects() {
        List<ProjectEntity> project = projectDao.getAll();
        return ResponseEntity.ok(new ResponseWrapper(new ListResp(project.size(), project)));
    }

    @Override
    public ResponseEntity getProjectsForUser() {
        List<ProjectEntity> project = projectDao.getAllByUser(AuthorizedUser.id());
        return ResponseEntity.ok(new ResponseWrapper(new ListResp(project.size(), project)));
    }

    @Override
    public ResponseEntity createProject(CreateProjectReq createProjectReq) {
        ProjectEntity projectEntity = ProjectEntity.of(createProjectReq);
        projectDao.saveOrUpdate(projectEntity);

        List<Integer> userIds = createProjectReq.getUserIds();
        userIds.add(AuthorizedUser.id());

        List<UserEntity> usersToProject = userDao.findAllById(userIds);

        projectDao.saveOrUpdate(usersToProject.stream().
                map(item -> ProjectUserEntity.of(item, projectEntity)).collect(toList()));
        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }

    @Override
    public ResponseEntity addDeveloperToProject(AddUserToProjectReq addUserToProjectReq) {
        if (addUserToProjectReq.getProjectId() == 0)
            throw new IllegalArgumentException("Project id must not be null");

        ProjectEntity entity = projectDao.getById(addUserToProjectReq.getProjectId());
        List<UserEntity> usersToProject = userDao.findAllById(addUserToProjectReq.getIds());
        projectDao.saveOrUpdate(usersToProject.stream().
                map(item -> ProjectUserEntity.of(item, entity)).collect(toList()));
        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }
}
