package com.example.loginapp._core.config;

import com.example.loginapp._core.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// WebMvcConfigurer : 설정하고 싶은 것들이 들어있는
@Configuration // WebMvcConfigurer를 implements해서 WebMvcConfig를 IoC에 등록해야됨 (@Component 포함되어있음)
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/");
    }
}