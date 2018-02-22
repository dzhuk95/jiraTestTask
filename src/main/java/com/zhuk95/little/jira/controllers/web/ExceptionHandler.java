package com.zhuk95.little.jira.controllers.web;

import com.zhuk95.little.jira.models.api.ResponseWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.zhuk95.little.jira.util.UtilVaraibles.headers;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity handleException(HttpServletRequest req, Exception e) {
        return new ResponseEntity(new ResponseWrapper(e.getMessage()), headers.get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
