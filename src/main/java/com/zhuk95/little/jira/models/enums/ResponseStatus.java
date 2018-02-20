package com.zhuk95.little.jira.models.enums;

public enum ResponseStatus {
    SUCCESS(0), FAILURE(1);
    private int id;

    ResponseStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
