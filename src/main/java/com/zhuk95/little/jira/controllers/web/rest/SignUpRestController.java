package com.zhuk95.little.jira.controllers.web.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO Add Logic
@RestController
@RequestMapping(value = "api/registration", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SignUpRestController {

    @PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity sigUp() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "registration", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registration() {
        return ResponseEntity.ok().build();
    }
}
