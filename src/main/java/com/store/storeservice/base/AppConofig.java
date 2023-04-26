package com.store.storeservice.base;

import com.store.storeservice.dao.CommonMapper;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class AppConofig {
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource d=new DriverManagerDataSource();
//        d.setUrl("jdbc:mysql://192.168.1.19:3306/store?useSSL=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
//        d.setUsername("root");
//        d.setPassword("123456");
//        return d;
//    }

    @Autowired
    CommonMapper commonMapper;

    @Bean
    public void initCheckData() {

        System.out.println("---------校验数据库 开始-----");

        System.out.println("---------创建用户表-----");
        commonMapper.createUserInfo();

        System.out.println("---------创建账户表-----");
        commonMapper.createAccount();

        System.out.println("---------创建属性表-----");
        commonMapper.createAttribute();

//        List<String> tabelNull=new ArrayList<>();
//        tabelNull.add("age");
//        tabelNull.add("size");
//        commonMapper.createAutoTaskResult("new",tabelNull);

        String a = UUID.randomUUID().toString();
        System.out.println("---------校验数据库 结束-----" + a);

    }
}
