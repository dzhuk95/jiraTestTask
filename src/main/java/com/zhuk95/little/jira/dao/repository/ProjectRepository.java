package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    @Query(value = "SELECT pe FROM ProjectEntity as pe",
            countQuery = "SELECT count (pe) FROM ProjectEntity as pe")
    Page<ProjectEntity> getAll(Pageable pageable);

    @Query(value = "SELECT pe FROM ProjectEntity as pe WHERE pe.id=:projectId")
    Optional<ProjectEntity> getById(@Param("projectId") int projectId);
}
