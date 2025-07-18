package com.service.quickblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${frontend.url}")
    private String[] frontendUrl;

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").
        allowCredentials(true)
        .allowedHeaders("*")
        .allowedMethods("*")
        .allowedOrigins(frontendUrl);
    }

}
