package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.CommentDao;
import com.zhuk95.little.jira.dao.repository.CommentRepository;
import com.zhuk95.little.jira.models.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentEntity saveOrUpdate(CommentEntity comment) {
        return null;
    }

    @Override
    public void delete(CommentEntity comment) {

    }
}
