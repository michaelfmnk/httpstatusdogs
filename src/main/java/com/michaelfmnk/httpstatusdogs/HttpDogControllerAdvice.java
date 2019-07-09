package com.michaelfmnk.httpstatusdogs;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

@ControllerAdvice
public class HttpDogControllerAdvice implements ResponseBodyAdvice<Object> {
    private final String HEADER_NAME = "StatusDog";
    private final String LINK_TEMPLATE = "https://httpstatusdogs.com/img/%s.jpg";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        resolveStatus(response)
                .map(this::getPictureLinkForStatus)
                .ifPresent(link -> response.getHeaders().add(HEADER_NAME, link));

        return body;
    }

    private String getPictureLinkForStatus(Integer status) {
        return String.format(LINK_TEMPLATE, status);
    }

    private Optional<Integer> resolveStatus(ServerHttpResponse response) {
        Optional<Integer> resolvedStatus = Optional.empty();
        if (response instanceof ServletServerHttpResponse) {
            resolvedStatus = Optional.of(((ServletServerHttpResponse) response).getServletResponse().getStatus());
        }
        return resolvedStatus;
    }
}
