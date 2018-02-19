package com.zhuk95.little.jira.models;


import com.zhuk95.little.jira.models.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private UserEntity userEntity;

    public AuthorizedUser(UserEntity user) {
        super(user.getEmail(), user.getPassWord(), user.isActive(), true, true, true,
                Collections.singletonList(user.getRole()));
        this.userEntity = user;
    }

    public static AuthorizedUser safeGet() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null) {
                return null;
            }
            Object principal = auth.getPrincipal();
            return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        if (user == null) throw new AuthenticationCredentialsNotFoundException("No authorized user found");
        return user;
    }

    public static int id() {
        return get().userEntity.getId();
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    @Override
    public String toString() {
        return userEntity.toString();
    }
}
