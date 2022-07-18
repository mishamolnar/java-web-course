package com.bobo.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class TestAppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
