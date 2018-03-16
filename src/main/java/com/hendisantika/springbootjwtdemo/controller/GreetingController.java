package com.hendisantika.springbootjwtdemo.controller;

import com.hendisantika.springbootjwtdemo.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/03/18
 * Time: 06.05
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api")
public class GreetingController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(new Date(), String.format(template, name));
    }
}