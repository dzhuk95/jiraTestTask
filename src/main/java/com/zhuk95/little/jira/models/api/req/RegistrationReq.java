package com.zhuk95.little.jira.models.api.req;

import com.zhuk95.little.jira.models.enums.Role;

import javax.validation.constraints.NotNull;

public class RegistrationReq {
    @NotNull(message = "Email must not be null")
    private String email;
    @NotNull(message = "Password must not be null")
    private String password;
    @NotNull(message = "First Name must not be null")
    private String firstName;
    @NotNull(message = "Last Name must not be null")
    private String lastName;
    @NotNull(message = "Role must not be null")
    private Role role;

    public RegistrationReq() {
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
