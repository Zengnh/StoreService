package com.store.storeservice.bean.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 账号信息表
 * 账户密码
 */
@Data
@TableName("tab_account")
public class Account {
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    @TableField("account")
    String account;
    @TableField("pwd")
    String pwd;
    @TableField("type")
    int type;

    @ApiModelProperty("关联用户信息表")
    @TableField("uid")
    String uid;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss“,timezone = “GMT+8“)
    @TableField("register_time")
    Date registerTime;// default current_timestamp comment '注册时间'
}
