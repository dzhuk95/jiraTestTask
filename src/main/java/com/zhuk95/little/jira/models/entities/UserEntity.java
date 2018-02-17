package com.zhuk95.little.jira.models.entities;

import com.zhuk95.little.jira.models.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String passWord;

    @Column(name = "first_name", nullable = false)
    private String firsName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated
    @Column(name = "role")
    private Role role;

    public UserEntity() {
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

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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
