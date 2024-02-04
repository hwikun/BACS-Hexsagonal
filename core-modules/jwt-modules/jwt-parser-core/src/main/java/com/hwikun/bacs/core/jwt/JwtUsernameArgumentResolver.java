package com.hwikun.bacs.core.jwt;

import com.hwikun.bacs.core.jwt.properties.JwtProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
@Component
@RequiredArgsConstructor
public class JwtUsernameArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpServletRequest request;
    private final JwtProperties jwtProperties;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(JwtUsername.class) != null &&
                parameter.getParameterType().equals(String.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
        String jwt = JwtParser.getJwtFromRequest(request);
        return JwtParser.getUsernameFromJwt(jwt, jwtProperties.secretKey());
    }
}