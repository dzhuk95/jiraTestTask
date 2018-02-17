package com.zhuk95.little.jira.models.enums;

public enum Role {
    DEVELOPER(0), MANAGER(1);

    private Integer id;

    public Integer getId() {
        return id;
    }

    Role(Integer id) {
        this.id = id;
    }
}
