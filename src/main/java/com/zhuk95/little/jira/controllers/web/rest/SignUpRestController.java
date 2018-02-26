package com.zhuk95.little.jira.controllers.web.rest;

import com.zhuk95.little.jira.models.api.req.LoginReq;
import com.zhuk95.little.jira.models.api.req.RegistrationReq;
import com.zhuk95.little.jira.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SignUpRestController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping(value = "registration", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registration(@RequestBody @Validated RegistrationReq registrationReq) throws Exception {
       return signUpService.registration(registrationReq);
    }

    @PostMapping(value = "signUp", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity registration(@RequestBody @Validated LoginReq loginReq) throws Exception {
       return signUpService.login(loginReq);
    }
}
