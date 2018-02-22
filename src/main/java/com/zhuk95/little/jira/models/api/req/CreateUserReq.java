package com.zhuk95.little.jira.models.api.req;

import com.zhuk95.little.jira.models.enums.Role;

import javax.validation.constraints.NotNull;

public class CreateUserReq {
    @NotNull(message = "Email must not be null")
    private String email;
    @NotNull(message = "Password must not be null")
    private String password;

    public CreateUserReq() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
