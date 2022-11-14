package com.store.storeservice.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DTOLogin {
    @ApiModelProperty("账号")
    private String mobile;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("类型")
    private String type;
}
