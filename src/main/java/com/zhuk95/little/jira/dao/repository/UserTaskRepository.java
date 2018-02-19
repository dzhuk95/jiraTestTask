package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.UserTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTaskRepository extends JpaRepository<UserTaskEntity, Integer> {

    @Query("SELECT ute FROM UserTaskEntity as ute " +
            "inner join ute.task as te" +
            " inner join ute.user as ue" +
            " inner join te.project as pe " +
            "WHERE pe.id=:projectId")
    List<UserTaskEntity> getAllTask(@Param("projectId") int projectId);
}
