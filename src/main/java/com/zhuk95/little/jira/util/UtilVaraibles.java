package com.zhuk95.little.jira.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.regex.Pattern;

public class UtilVaraibles {
    public static ThreadLocal<HttpHeaders> headers = ThreadLocal.withInitial(() -> {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE));
        return headers;
    });

    public static ThreadLocal<Pattern> VALID_EMAIL_ADDRESS_REGEX = ThreadLocal.withInitial(() ->
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE));
}
