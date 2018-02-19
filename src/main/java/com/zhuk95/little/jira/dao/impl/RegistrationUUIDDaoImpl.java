package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.RegistrationUUIDDao;
import com.zhuk95.little.jira.dao.repository.RegistrationUUIDRepository;
import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegistrationUUIDDaoImpl implements RegistrationUUIDDao {
    @Autowired
    private
    RegistrationUUIDRepository registrationUUIDRepository;

    @Override
    public boolean save(RegistrationUUIDEntity registrationUUIDEntity) {
        return registrationUUIDRepository.save(registrationUUIDEntity).getId() != null;
    }

    @Override
    @Transactional
    @Modifying
    public void delete(RegistrationUUIDEntity registrationUUIDEntity) {
        registrationUUIDRepository.delete(registrationUUIDEntity);
    }

    @Override
    public RegistrationUUIDEntity getByUUID(String uuid) {
        return registrationUUIDRepository.getByUUID(uuid);
    }
}
