package com.zhuk95.little.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class LittleJiraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleJiraApplication.class, args);
    }

}
