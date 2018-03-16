package com.hendisantika.springbootjwtdemo.handler;

import com.hendisantika.springbootjwtdemo.exception.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/18
 * Time: 06.02
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SimpleAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        if (!"admin".equalsIgnoreCase(username) || !"password".equals(password)) {
            throw new BadCredentialsException("Invalid username and password");
        }

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ADMIN"));
        return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
    }

}
