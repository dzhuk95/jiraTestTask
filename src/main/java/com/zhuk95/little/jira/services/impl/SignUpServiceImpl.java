package com.zhuk95.little.jira.services.impl;

import com.zhuk95.little.jira.dao.RegistrationUUIDDao;
import com.zhuk95.little.jira.dao.UserDao;
import com.zhuk95.little.jira.models.api.req.RegistrationReq;
import com.zhuk95.little.jira.models.entities.RegistrationUUIDEntity;
import com.zhuk95.little.jira.models.entities.UserEntity;
import com.zhuk95.little.jira.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import static com.zhuk95.little.jira.util.utilVaraibles.VALID_EMAIL_ADDRESS_REGEX;

@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RegistrationUUIDDao registrationUUIDDao;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ResponseEntity registration(RegistrationReq registrationReq) throws Exception {
        String email = registrationReq.getEmail();
        Assert.isNull(userDao.getByEmail(email), "Current email is already used");
        if (!VALID_EMAIL_ADDRESS_REGEX.get().matcher(email).matches())
            throw new IllegalArgumentException("Email is not Valid");
        UserEntity entity = UserEntity.of(registrationReq);
        userDao.saveOrUpdate(entity);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        registrationUUIDDao.save(RegistrationUUIDEntity.of(uuid, entity));
        sendEmail(email, uuid);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public void activateAccount(String uuid) {
        RegistrationUUIDEntity rue = registrationUUIDDao.getByUUID(uuid);
        Assert.notNull(rue, "No such user in system");
        UserEntity ue = rue.getUser();
        ue.setActive(true);
        userDao.saveOrUpdate(ue);
        registrationUUIDDao.delete(rue);
    }

    private void sendEmail(String email, String uuid) throws UnknownHostException {
        String baseUrl = InetAddress.getLocalHost().getHostAddress();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Account activation");
        simpleMailMessage.setText("Follow this lint to activate your account " +
                "<a href=" + baseUrl + "/activate?uuid=" + uuid + " >here</a>");
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
