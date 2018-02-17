package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.RegistrationUUIDDao;
import com.zhuk95.little.jira.dao.repository.RegistrationUUIDRepository;
import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationUUIDDaoImpl implements RegistrationUUIDDao {
    @Autowired
    RegistrationUUIDRepository registrationUUIDRepository;

    @Override
    public void save(RegistrationUUIDEntity registrationUUIDEntity) {

    }

    @Override
    public void delete(RegistrationUUIDEntity registrationUUIDEntity) {

    }
}
