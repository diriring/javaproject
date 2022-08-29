package com.java.project.config;

import com.java.project.Interceptor.IdCheckInterceptor;
import com.java.project.Interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;
    private final IdCheckInterceptor idCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/member/myPage")
                .addPathPatterns("/member/memberUpdate")
                .addPathPatterns("/member/memberDelete")
                .addPathPatterns("/board/boardWrite")
                .addPathPatterns("/board/boardUpdate");

        registry.addInterceptor(idCheckInterceptor)
                .addPathPatterns("/board/boardUpdate");
    }
}
