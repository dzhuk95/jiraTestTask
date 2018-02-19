package com.zhuk95.little.jira.dao.impl;

import com.zhuk95.little.jira.dao.CommentDao;
import com.zhuk95.little.jira.dao.repository.CommentRepository;
import com.zhuk95.little.jira.models.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    @Modifying
    public CommentEntity saveOrUpdate(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    @Modifying
    public void delete(CommentEntity comment) {
        commentRepository.delete(comment);
    }
}
