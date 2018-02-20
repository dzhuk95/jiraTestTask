package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.dao.CommentDao;
import com.zhuk95.little.jira.dao.TaskDao;
import com.zhuk95.little.jira.models.api.ResponseWrapper;
import com.zhuk95.little.jira.models.api.req.CreateCommentReq;
import com.zhuk95.little.jira.models.api.req.EditCommentReq;
import com.zhuk95.little.jira.models.entities.CommentEntity;
import com.zhuk95.little.jira.models.enums.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("commentService")
public class CommentServiceImpl implements com.zhuk95.little.jira.services.CommentService {
    @Autowired
    private
    CommentDao commentDao;
    @Autowired
    private
    TaskDao taskDao;

    @Override
    public ResponseEntity addComment( CreateCommentReq createCommentReq) {
        if (createCommentReq.getTaskId() == 0)
            throw new IllegalArgumentException("Task id must not be 0");

        if (createCommentReq.getText().isEmpty())
            throw new IllegalArgumentException("Comment must not be empty");

        CommentEntity commentEntity = CommentEntity.of(createCommentReq.getText(),
                taskDao.get(createCommentReq.getTaskId()));
        commentDao.saveOrUpdate(commentEntity);

        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }
        //TODO add generic method
    private <T extends CreateCommentReq> void check(Class<T> addCommentReq) {

    }

    @Override
    public ResponseEntity editComment(@Validated EditCommentReq editCommentReq) {
        if (editCommentReq.getTaskId() == 0)
            throw new IllegalArgumentException("Task id must not be 0");

        if (editCommentReq.getText().isEmpty())
            throw new IllegalArgumentException("Comment must not be empty");

        CommentEntity commentEntity = commentDao.get(editCommentReq.getCommentId());
        commentEntity.setText(editCommentReq.getText());
        commentDao.saveOrUpdate(commentEntity);

        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }

    @Override
    public ResponseEntity deleteComment(int id) {
        if (id == 0)
            throw new IllegalArgumentException("Comment id must not be 0");
        commentDao.delete(id);

        return ResponseEntity.ok(new ResponseWrapper(ResponseStatus.SUCCESS));
    }
}
