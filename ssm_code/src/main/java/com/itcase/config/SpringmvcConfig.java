package com.itcase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.itcase.controller","com.itcase.config"})
@EnableWebMvc //JSON自动转换
public class SpringmvcConfig {
}
