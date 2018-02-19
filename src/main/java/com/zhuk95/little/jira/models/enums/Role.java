package com.zhuk95.little.jira.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DEVELOPER(0), MANAGER(1);

    private Integer id;

    public Integer getId() {
        return id;
    }

    Role(Integer id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
