package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;

public interface RegistrationUUIDDao {
    boolean save(RegistrationUUIDEntity registrationUUIDEntity);

    void delete(RegistrationUUIDEntity registrationUUIDEntity);

    RegistrationUUIDEntity getByUUID(String uuid);
}
