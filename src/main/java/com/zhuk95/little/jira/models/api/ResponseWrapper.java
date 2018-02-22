package com.zhuk95.little.jira.models.api;

import com.zhuk95.little.jira.models.enums.ResponseStatus;

import java.util.Objects;

public class ResponseWrapper {
    private ResponseStatus status;
    private String message;
    private Object body;

    public ResponseWrapper() {
    }

    public ResponseWrapper(ResponseStatus status, String message, Object body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public ResponseWrapper(ResponseStatus status) {
        this.status = status;
    }

    public ResponseWrapper(ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseWrapper ok() {
        return new ResponseWrapper(ResponseStatus.SUCCESS);
    }

    public static ResponseWrapper ok(Object o) {
        return new ResponseWrapper(ResponseStatus.SUCCESS, null, o);
    }

    public static ResponseWrapper failure() {
        return new ResponseWrapper(ResponseStatus.FAILURE);
    }

    public static ResponseWrapper failure(String str) {
        return new ResponseWrapper(ResponseStatus.FAILURE, str);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }

    public ResponseWrapper(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
