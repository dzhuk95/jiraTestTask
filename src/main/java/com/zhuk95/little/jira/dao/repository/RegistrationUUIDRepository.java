package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationUUIDRepository extends JpaRepository<RegistrationUUIDEntity, Integer> {

    @Query("SELECT rue FROM RegistrationUUIDEntity as rue WHERE rue.uuid=:uuid")
    RegistrationUUIDEntity getByUUID(@Param("uuid") String uuid);
}
