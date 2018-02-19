package com.zhuk95.little.jira;

import com.zhuk95.little.jira.controllers.web.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class LittleJiraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleJiraApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    public class SecureConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/", "/signUp", "/api/registration").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    .and()
                    .logout().logoutUrl("/logOut").permitAll()
                    .and()
                    .addFilter(new WebFilter());
//                    .authenticationProvider();
            http.csrf().disable().headers().frameOptions().disable();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**");
        }

    }

}
