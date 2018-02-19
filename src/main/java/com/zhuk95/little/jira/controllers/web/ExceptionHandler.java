package com.zhuk95.little.jira.controllers.web;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.zhuk95.little.jira.util.utilVaraibles.headers;

@ControllerAdvice(annotations = {RestController.class})
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Order(Ordered.LOWEST_PRECEDENCE - 1)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(e.getMessage(), headers.get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Order(Ordered.LOWEST_PRECEDENCE)
    @ResponseBody
    public ResponseEntity handleException(HttpServletRequest req, Exception e) {
        return new ResponseEntity(null, headers.get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResponseEntity<String> wrongPermissionException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(e.getMessage(), headers.get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ResponseEntity<String> notFoundException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(e.getMessage(), headers.get(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<String> illegalArgumentException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(e.getMessage(), headers.get(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<String> nullPointException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(e.getMessage(), headers.get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
