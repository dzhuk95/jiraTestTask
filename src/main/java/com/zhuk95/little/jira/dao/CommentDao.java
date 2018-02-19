package com.zhuk95.little.jira.dao;

import com.zhuk95.little.jira.models.entities.CommentEntity;

public interface CommentDao {

    CommentEntity saveOrUpdate(CommentEntity comment);

    void delete(int comment);

    CommentEntity get(int id);
}
