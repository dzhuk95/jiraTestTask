package com.zhuk95.little.jira.controllers.web;

import com.zhuk95.little.jira.models.AuthorizedUser;
import com.zhuk95.little.jira.models.entities.UserEntity;
import com.zhuk95.little.jira.models.enums.Role;
import javassist.NotFoundException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filter(request, response, chain);
    }

    private void filter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getRequestURI().contains("api/projects")
                && req.getMethod().equalsIgnoreCase("post")) {
            UserEntity ue = AuthorizedUser.safeGet().getUserEntity();
            if (ue == null)
                throw new IllegalArgumentException("User is not login");
            if (ue.getRole() == Role.DEVELOPER)
                throw new IllegalArgumentException("Developer can not create projects");
            chain.doFilter(req, resp);
        }
    }
}
