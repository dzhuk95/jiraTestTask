package com.zhuk95.little.jira.services;

import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity addComment();

    ResponseEntity editComment();

    ResponseEntity deleteComment();

}
