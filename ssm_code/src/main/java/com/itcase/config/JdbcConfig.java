package com.itcase.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


//配置：连接池、事务管理器
public class JdbcConfig {
        @Value("${jdbc.driver}")
        private String driver;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String password;

        //设置连接池
        @Bean
        public DataSource dataSource(){
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        }

        //设置事务管理器 (声明式事务)
        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource){
            //PlatformTransactionManager是DataSourceTransactionManager的父接口
            DataSourceTransactionManager dstm = new DataSourceTransactionManager();
            dstm.setDataSource(dataSource);
            return dstm;
        }

}
