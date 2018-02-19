package com.zhuk95.little.jira.controllers.web.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DELEVOPER(0),
    ROLE_MANAGER(1);
    private int value;

    Role(int id) {
        this.value = id;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
