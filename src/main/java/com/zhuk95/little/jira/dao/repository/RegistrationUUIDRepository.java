package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationUUIDRepository extends JpaRepository<RegistrationUUIDEntity, Integer> {
}
