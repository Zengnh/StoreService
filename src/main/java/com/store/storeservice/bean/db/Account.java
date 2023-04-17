package com.store.storeservice.bean.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 账号信息表
 * 账户密码
 */
@Data
@TableName("account_pwd")
public class Account {
    @TableId(value = "id",type = IdType.AUTO)
    int id;
    @TableField("account")
    String account;
    @TableField("pwd")
    String pwd;

}
