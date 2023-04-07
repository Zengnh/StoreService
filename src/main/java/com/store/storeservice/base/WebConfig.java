package com.store.storeservice.base;

import io.swagger.annotations.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);

        // 注册拦截器
        registry.addInterceptor(getUserTokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
        ;
        // 一定要加
        WebMvcConfigurer.super.addInterceptors(registry);
    }


//     @Bean
    public UserTokenInterceptors getUserTokenInterceptor() {
        return new UserTokenInterceptors();
    }

}
