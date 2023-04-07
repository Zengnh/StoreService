package com.store.storeservice.controller;

import com.store.storeservice.base.Result;
import com.store.storeservice.bean.dto.DTOLogin;
import com.store.storeservice.bean.vo.VOLogin;
import com.store.storeservice.utils.QRCodeUtil;
import com.store.storeservice.utils.ToolFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.util.Enumeration;

@Api(tags = "用户属性相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

//    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
//    produces 对应请求 Content-Type
    @ApiOperation("获取ip地址跟端口号")
    @ResponseBody
    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
    public Result<VOLogin> loginConfig(@Validated @RequestBody DTOLogin login) {
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


}