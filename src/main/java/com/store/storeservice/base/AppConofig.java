package com.store.storeservice.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConofig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource d=new DriverManagerDataSource();
        d.setUrl("jdbc:mysql://192.168.1.19:3306/jms_uat?useSSL=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
        d.setUsername("test");
        d.setPassword("z1k80r51");
        return d;
    }
}
