package com.store.storeservice.controller;

import com.store.storeservice.base.Result;
import com.store.storeservice.base.User;
import com.store.storeservice.base.UserTokenInterceptors;
import com.store.storeservice.bean.dto.DTOLogin;
import com.store.storeservice.bean.dto.DTOUserInfo;
import com.store.storeservice.bean.vo.VOUserInfo;
import com.store.storeservice.dao.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Api(tags = "用户属性相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

//    @Autowired
//    private RedisTemplate redisTemplate;//注入redisTemplate



    @Autowired
    private UserMapper userMapper;


    //    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
//    produces 对应请求 Content-Type
    @ApiOperation("用户登录接口,1、手机验证码登录，2、微信登录，3、账号密码的登录")
    @ResponseBody
    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
    public Result<VOUserInfo> userLogin(@Validated @RequestBody DTOLogin login) {
        VOUserInfo result = new VOUserInfo();
        if (login.getType() == 1) {
//            1、手机验证码登录
        } else if (login.getType() == 2) {
//            2微信登录
        } else if (login.getType() == 3) {
//            3、账号密码登录

        } else if (login.getType() == 4) {

        }
        User user = new User();
        user.name = result.name;
        user.userId = result.uid;
        String token = System.currentTimeMillis() + result.uid;//生成token
        result.access_token = token;

        //保存到redis 数据库中。用于下次登录校验
//        redisTemplate.opsForValue().set(UserTokenInterceptors.TOKENID + token, user, UserTokenInterceptors.CACHE_TIME, TimeUnit.SECONDS);//存储token
        return Result.succeed(result);
    }

    @ApiOperation("获取用户信息")
    @ResponseBody
    @PostMapping(value = {"/userInfo"}, produces = "application/json;charset=UTF-8")
    public Result<VOUserInfo> userInfo(@Validated @RequestBody DTOUserInfo userinfo) {
        VOUserInfo result = userMapper.getUserInfo("id");
        return Result.succeed(result);
    }

}