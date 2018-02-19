package com.zhuk95.little.jira.services;

import com.zhuk95.little.jira.models.api.req.RegistrationReq;
import org.springframework.http.ResponseEntity;

public interface SignUpService {

    ResponseEntity registration(RegistrationReq registrationReq) throws Exception;

    void activateAccount(String uuid);
}
