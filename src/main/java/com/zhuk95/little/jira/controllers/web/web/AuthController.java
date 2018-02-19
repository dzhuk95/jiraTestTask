package com.zhuk95.little.jira.controllers.web.web;

import com.zhuk95.little.jira.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    SignUpService signUpService;

    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/activate")
    public String activationPage(@RequestParam String uuid) {
        signUpService.activateAccount(uuid);
        return "login";
    }

    @GetMapping(value = "signUp")
    public String signUp() {
        //TODO sign up
        return "signUp";
    }
}
