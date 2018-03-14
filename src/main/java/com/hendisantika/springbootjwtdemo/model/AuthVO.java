package com.hendisantika.springbootjwtdemo.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/03/18
 * Time: 07.13
 * To change this template use File | Settings | File Templates.
 */
public class AuthVO {
    private String username;
    private String password;
    private String[] roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

}
