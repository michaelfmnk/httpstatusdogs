package dev.fomenko.httpstatusdogs.config;

import dev.fomenko.httpstatusdogs.HttpDogControllerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpStatusDogsConfiguration {

    @Bean
    public HttpDogControllerAdvice httpStatusDogsControllerAdvice() {
        return new HttpDogControllerAdvice();
    }
}
