package com.zhuk95.little.jira.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "registration_user_code")
public class RegistrationUUIDEntity extends BaseEntity {
    private String uuid;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public RegistrationUUIDEntity() {
    }

    public RegistrationUUIDEntity(String uuid, UserEntity user) {
        this.uuid = uuid;
        this.user = user;
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

    public static RegistrationUUIDEntity of(String uuid, UserEntity entity) {
        return new RegistrationUUIDEntity(uuid, entity);
    }
}
