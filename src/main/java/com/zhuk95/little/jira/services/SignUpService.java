package com.zhuk95.little.jira.services;

import com.zhuk95.little.jira.models.api.req.CreateUserReq;
import com.zhuk95.little.jira.models.api.req.RegistrationReq;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SignUpService extends UserDetailsService {

    ResponseEntity registration(RegistrationReq registrationReq) throws Exception;

    ResponseEntity login(CreateUserReq createUserReq) throws Exception;

    void activateAccount(String uuid);
}
