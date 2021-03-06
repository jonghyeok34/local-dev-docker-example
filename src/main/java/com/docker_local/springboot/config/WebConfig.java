package com.docker_local.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // HEAD, OPTIONS, GET, PUT, POST, DELETE, PATCH

        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(false).maxAge(36000);
        // registry.addMapping("/**") // 모든 요청에 대해서
        // .allowedOrigins("*").allowCredentials(true).maxAge(3600)
        // // .allowedHeaders("*")
        // .allowedHeaders("Accept", "Content-Type", "Origin", "Authorization",
        // "X-Auth-Token", "lang", "AdminToken", "X-Ajax-call",
        // "X-CSRF-TOKEN").exposedHeaders("X-Auth-Token", "Authorization", "lang",
        // "AdminToken")
        // // .allowedMethods("HEAD", "OPTIONS", "POST", "GET", "DELETE", "PUT",
        // "PATCH");
        // .allowedMethods("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // registry.addResourceHandler("/*.worker.js").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
    }
}
