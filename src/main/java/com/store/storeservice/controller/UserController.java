package com.store.storeservice.controller;

import com.store.storeservice.base.Result;
import com.store.storeservice.bean.db.TableUser;
import com.store.storeservice.bean.dto.DTOLogin;
import com.store.storeservice.bean.vo.VOLogin;
import com.store.storeservice.dao.CommonMapper;
import com.store.storeservice.dao.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "用户属性相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

//    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
//    produces 对应请求 Content-Type
    @ApiOperation("获取ip地址跟端口号")
    @ResponseBody
    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
    public Result<VOLogin> loginConfig(@Validated @RequestBody DTOLogin login) {
//        List<Center> data=centerByTypeToMapper.getList();
      TableUser user= userMapper.selectById(1);
//        List<TableUser> userList=userMapper.getUserInfo(null);
        if (login.getType() ==1) {
//            密码登录,账号密码登录
        }else  if (login.getType() == 2) {
        }else  if (login.getType() == 3) {
        }else  if (login.getType() == 4) {

        } else {

        }
        VOLogin result = new VOLogin();
        return Result.succeed(result);
    }

    @Autowired
    CommonMapper commonMapper;
    @ResponseBody
    @GetMapping(value = {"/text"}, produces = "application/json;charset=UTF-8")
    public Result<TableUser>  textTc(){
        List<String> tabelNull=new ArrayList<>();
        tabelNull.add("age");
        tabelNull.add("size");
        commonMapper.createAutoTaskResult("textTable",tabelNull);

        return Result.succeed(userMapper.selectById(1));
    }


}