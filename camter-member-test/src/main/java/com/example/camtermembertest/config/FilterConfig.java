package com.example.camtermembertest.config;

import com.example.camtermembertest.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterFilterRegistrationBean() {
        FilterRegistrationBean<JwtFilter> bean = new FilterRegistrationBean<>(jwtFilter);
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }
}
