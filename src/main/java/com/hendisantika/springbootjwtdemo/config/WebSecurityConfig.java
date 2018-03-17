package com.hendisantika.springbootjwtdemo.config;

import com.hendisantika.springbootjwtdemo.filter.ExceptionHandlerFilter;
import com.hendisantika.springbootjwtdemo.filter.JwtAuthenticationFilter;
import com.hendisantika.springbootjwtdemo.filter.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/18
 * Time: 06.03
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private ExceptionHandlerFilter exceptionHandlerFilter;

    @Autowired
    private JwtLoginFilter jwtLoginFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers("/").permitAll().antMatchers(HttpMethod.POST, "/login")
                .permitAll().anyRequest().authenticated().and()
                .addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionHandlerFilter, JwtAuthenticationFilter.class);
    }

}