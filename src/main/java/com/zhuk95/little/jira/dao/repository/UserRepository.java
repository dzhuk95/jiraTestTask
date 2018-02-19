package com.zhuk95.little.jira.dao.repository;

import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT ue FROM UserEntity as ue WHERE ue.active=true")
    List<UserEntity> getAllUser();
    @Query("SELECT ue FROM UserEntity as ue WHERE ue.email=:email")
    UserEntity findByEmail(@Param("email")String email);

    @Query("SELECT ue FROM UserEntity as ue WHERE ue.id in:ids AND ue.active=true")
    List<UserEntity> findById(@Param("ids")List<Integer> ids);
}
