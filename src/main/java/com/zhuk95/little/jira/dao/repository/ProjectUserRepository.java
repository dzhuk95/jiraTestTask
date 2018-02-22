package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.ProjectUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUserEntity, Integer> {

    @Query(value = "SELECT pue FROM ProjectUserEntity as pue " +
            "inner join fetch pue.project as p" +
            "inner join fetch pue.user as u" +
            " WHERE u.id=:userId",
            countQuery = "SELECT count (pue) FROM ProjectUserEntity as pue " +
                    "inner join fetch pue.project as p" +
                    "inner join fetch pue.user as u" +
                    " WHERE u.id=:userId")
    Page<ProjectUserEntity> getByUserId(@Param("userId") int userId, Pageable pageable);
}
