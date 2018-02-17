package com.zhuk95.little.jira.models.api.req;

import javax.validation.constraints.NotNull;

public class RegistrtionReq {
    @NotNull
    private String email;
    @NotNull
    private String passWord;
    @NotNull
    private String firstName;
    @NotNull
    private String lastNAme;

    public RegistrtionReq() {
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

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }
}
