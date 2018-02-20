package com.zhuk95.little.jira.controllers.web.rest;

import com.zhuk95.little.jira.models.api.req.CreateCommentReq;
import com.zhuk95.little.jira.models.api.req.EditCommentReq;
import com.zhuk95.little.jira.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsRestController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addComment(@RequestBody @Validated CreateCommentReq createCommentReq) {
        return commentService.addComment(createCommentReq);
    }

    @PostMapping(value = "edit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity editComment(@RequestBody @Validated EditCommentReq editCommentReq) {
        return commentService.editComment(editCommentReq);
    }

    @DeleteMapping
    public ResponseEntity deleteEntity(@RequestParam int id) {
        return commentService.deleteComment(id);
    }
}
