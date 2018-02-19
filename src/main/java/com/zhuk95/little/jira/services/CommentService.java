package com.zhuk95.little.jira.services;

import com.zhuk95.little.jira.models.api.req.CreateCommentReq;
import com.zhuk95.little.jira.models.api.req.EditCommentReq;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity addComment(CreateCommentReq addCommentReq);

    ResponseEntity editComment(EditCommentReq editCommentReq);

    ResponseEntity deleteComment(int id);

}
