package com.store.storeservice.base;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//定义在方法上
@Retention(RetentionPolicy.RUNTIME)//注解的时间
@Documented//标识是一个注解
public @interface NoAuthoriztion {
}
