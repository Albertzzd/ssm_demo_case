package com.itcase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//Spring配置类
@ComponentScan("com.itcase.service")//扫描指定包下的类，并添加到Ioc容器
@PropertySource("classpath:db.properties")//加载外部配置文件
@Import({JdbcConfig.class,MybatisConfig.class})//引入配置类
@EnableTransactionManagement//开启事物管理支持
public class SpringConfig {
}
