package com.itcase.config;

import com.itcase.controller.Interceptor.TimeConsumeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//拦截器配置类
@Configuration
public class SpringmvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private TimeConsumeInterceptor timeConsumeInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器   设定拦截的访问路径，路径可以通过可变参数设置多个
        registry.addInterceptor(timeConsumeInterceptor)
                .addPathPatterns("/book","/book/*");
    }
}