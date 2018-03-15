package com.hendisantika.springbootjwtdemo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.springbootjwtdemo.exception.AuthenticationException;
import com.hendisantika.springbootjwtdemo.model.AuthVO;
import com.hendisantika.springbootjwtdemo.service.TokenAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/03/18
 * Time: 05.18
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenAuthService tokenAuthService;

    public JwtLoginFilter(@Value("/login") String url, @Autowired AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        AuthVO creds = objectMapper.readValue(request.getInputStream(), AuthVO.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
                creds.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException {
        String token = tokenAuthService.addAuthentication(auth);
        res.addHeader("X-Token-Gen", token);
    }
}