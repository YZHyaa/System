package com.llxs.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.llxs.backend.config.interceptor.LoginInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /*
        登录拦截
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/superman/**");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //registry.addResourceHandler("/imgs/**").addResourceLocations("file:C:/Users/13275/Documents/Uploads/linlixs/");
        registry.addResourceHandler("/imgs/**").addResourceLocations("file:/java/images/");
    }

}
