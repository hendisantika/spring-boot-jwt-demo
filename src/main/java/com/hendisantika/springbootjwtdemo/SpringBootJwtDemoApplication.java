package com.hendisantika.springbootjwtdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orbitz.consul.Consul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtDemoApplication.class, args);
	}

    @Bean
    Consul getConsulClient() {
        return Consul.builder().build();
    }

    @Bean
    ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
