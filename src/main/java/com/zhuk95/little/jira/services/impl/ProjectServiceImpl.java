package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.models.api.ResponseWrapper;
import com.zhuk95.little.jira.dao.ProjectDao;
import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.models.AuthorizedUser;
import com.zhuk95.little.jira.models.api.req.AddUserToProjectReq;
import com.zhuk95.little.jira.models.api.req.CreateProjectReq;
import com.zhuk95.little.jira.models.api.req.GridReq;
import com.zhuk95.little.jira.models.api.resp.ListResp;
import com.zhuk95.little.jira.models.entities.ProjectEntity;
import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;
import com.zhuk95.little.jira.models.enums.ResponseStatus;
import com.zhuk95.little.jira.services.ProjectService;
import com.zhuk95.little.jira.util.UtilVaraibles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity getProjects(GridReq gridReq) {
        Pageable pageable = new PageRequest(gridReq.getCurrentPage(), gridReq.getLimit());
        Page<ProjectEntity> project = projectDao.getAll(pageable);
        return ResponseEntity.ok(ResponseWrapper.ok(new ListResp(project.getTotalElements(),
                project.getContent())));
    }

    @Override
    public ResponseEntity getProjectsForUser(GridReq gridReq) {
        Pageable pageable = new PageRequest(gridReq.getCurrentPage(), gridReq.getLimit());
        Page<ProjectUserEntity> project = projectDao.getAllByUser(AuthorizedUser.id(), pageable);
        return ResponseEntity.ok(ResponseWrapper.ok(new ListResp(project.getTotalElements(),
                project.getContent())));
    }

    @Override
    public ResponseEntity createProject(CreateProjectReq createProjectReq) {
        ProjectEntity projectEntity = ProjectEntity.of(createProjectReq);
        projectDao.saveOrUpdate(projectEntity);

        List<Integer> userIds1 = createProjectReq.getUserIds();
        List<Integer> userIds = userIds1 == null ?
                new ArrayList<>() : userIds1;
        userIds.add(AuthorizedUser.id());

        List<UserEntity> usersToProject = userDao.findAllById(userIds);

        projectDao.saveOrUpdate(usersToProject.stream().
                map(item -> ProjectUserEntity.of(item, projectEntity)).collect(toList()));
        return ResponseEntity.ok(ResponseWrapper.ok());
    }

    @Override
    public ResponseEntity addDeveloperToProject(AddUserToProjectReq addUserToProjectReq) {
        if (addUserToProjectReq.getProjectId() == 0)
            throw new IllegalArgumentException("Project id must not be null");

        Optional<ProjectEntity> entity = projectDao.getById(addUserToProjectReq.getProjectId());
        if (entity.isPresent()) {
            List<UserEntity> usersToProject = userDao.findAllById(addUserToProjectReq.getIds());
            projectDao.saveOrUpdate(usersToProject.stream().
                    map(item -> ProjectUserEntity.of(item, entity.get())).collect(toList()));
            return ResponseEntity.ok(ResponseWrapper.ok());
        } else
            return new ResponseEntity(ResponseWrapper.failure("Project not found"), UtilVaraibles.headers.get(),
                    HttpStatus.NOT_FOUND);
    }
}
