package com.store.storeservice.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DTOUserInfo {
    @ApiModelProperty("需要查询的用户id")
    private String userId;
}
