package com.store.storeservice.controller;

import com.store.storeservice.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/redis")
@ResponseBody
public class RequestController {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @GetMapping(value = "/key")
//    public String putKey(String key, String value){
//        this.redisTemplate.opsForValue().set(key,value,30, TimeUnit.SECONDS);
//
//        System.out.println(this.redisTemplate.opsForValue().get(key));
//        return "1";
//    }
//
//    @GetMapping(value = "/object")
//    public String putObject(){
//        User user = new User("河南大学", "userid001");
//        // 序列化对象
//        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
//        this.redisTemplate.opsForValue().set("user", user,30, TimeUnit.SECONDS);
//
//        System.out.println(this.redisTemplate.opsForValue().get("user"));
//        return "1";
//    }
//
//    @GetMapping(value = "/list")
//    public String putList(){
//
//        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
//        this.redisTemplate.opsForList().leftPush("users", new User("河南大学", "userid001"));
//
//        System.out.println(this.redisTemplate.opsForList().range("users", 0, -1));
//        return "1";
//    }
//
//    @GetMapping(value = "/map")
//    public String putMap(){
//        Map<String, String> myMap = new HashMap<>();
//        myMap.put("name", "河南大学");
//        myMap.put("age", "20");
//        this.redisTemplate.opsForHash().putAll("map", myMap);
//
//        System.out.println(this.redisTemplate.opsForHash().get("map", "name"));
//        return "1";
//    }

}