package com.zhuk95.little.jira.models.entities;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class RegistrationUUIDEntity extends BaseEntity {
    private String uuid;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public RegistrationUUIDEntity() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
