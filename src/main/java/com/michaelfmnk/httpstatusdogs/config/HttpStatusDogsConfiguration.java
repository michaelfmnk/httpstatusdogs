package com.michaelfmnk.httpstatusdogs.config;

import com.michaelfmnk.httpstatusdogs.HttpDogControllerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpStatusDogsConfiguration {

    @Bean
    public HttpDogControllerAdvice httpStatusDogsControllerAdvice() {
        return new HttpDogControllerAdvice();
    }
}
