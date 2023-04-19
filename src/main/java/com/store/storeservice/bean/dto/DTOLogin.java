package com.store.storeservice.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DTOLogin {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("类型：1、手机验证码登录，2、微信登录，3、账号密码的登录")
    private int type;
}
