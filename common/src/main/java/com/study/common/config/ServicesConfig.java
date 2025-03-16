package com.study.common.config;


import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class ServicesConfig {

    @Bean
    Retryer retryer() {
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(1L), 3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
