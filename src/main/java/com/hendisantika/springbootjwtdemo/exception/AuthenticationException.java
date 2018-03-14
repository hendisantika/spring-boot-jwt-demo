package com.hendisantika.springbootjwtdemo.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/03/18
 * Time: 05.58
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationException extends RuntimeException {

    private static final long serialVersionUID = -5059606188041833051L;

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);

    }

    public AuthenticationException(String message) {
        super(message);

    }

    public AuthenticationException(Throwable cause) {
        super(cause);

    }

}