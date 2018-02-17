package com.zhuk95.little.jira.controllers.web.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO add logic
@RestController
@RequestMapping(value = "api/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsRestController {

    @GetMapping("all")
    public ResponseEntity getAllComments(@RequestParam int taskId) {

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getComment(@RequestParam int commentId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addComment() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "edit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity editComment() {
        return ResponseEntity.ok().build();
    }
}
