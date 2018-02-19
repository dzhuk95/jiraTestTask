package com.zhuk95.little.jira.models.api.req;

import com.zhuk95.little.jira.models.enums.Role;

import javax.validation.constraints.NotNull;

public class RegistrationReq {
    @NotNull
    private String email;
    @NotNull
    private String passWord;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Role role;

    public RegistrationReq() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
