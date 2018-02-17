package com.zhuk95.little.jira.models.enums;

public enum TaskStatus {
    WAITIN(0),IMPLEMENTATION(1),VERIFYING(2),RELEASING(3),;
    private int id;

    TaskStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
