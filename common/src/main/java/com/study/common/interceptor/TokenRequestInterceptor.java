package com.study.common.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenRequestInterceptor implements RequestInterceptor {
    /**
     * @param template 请求模板
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header("token", UUID.randomUUID().toString());
    }
}
