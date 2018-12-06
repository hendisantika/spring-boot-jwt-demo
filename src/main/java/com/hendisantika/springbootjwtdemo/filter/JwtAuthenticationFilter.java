package com.hendisantika.springbootjwtdemo.filter;

import com.hendisantika.springbootjwtdemo.service.TokenAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/03/18
 * Time: 05.17
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtAuthenticationFilter extends GenericFilterBean {

    private static final String TOKEN_HEADER = "Authorization";

    @Autowired
    private TokenAuthService tokenAuthService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        String token = ((HttpServletRequest) request).getHeader(TOKEN_HEADER);

        Authentication authentication = tokenAuthService.getAuthentication(token);
//        Authentication authentication = tokenAuthService.getAuthentication((HttpServletRequest) request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

}