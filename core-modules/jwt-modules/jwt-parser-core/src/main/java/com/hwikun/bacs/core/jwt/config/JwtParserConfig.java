package com.hwikun.bacs.core.jwt.config;


import com.hwikun.bacs.core.jwt.JwtUsernameArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JwtParserConfig implements WebMvcConfigurer {
    private final JwtUsernameArgumentResolver jwtUsernameArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtUsernameArgumentResolver);
    }
}