package com.store.storeservice.bean.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
//@NoArgsConstructor
@Data
@TableName("user_info")
public class TableUser {
    /**
     * 员工 id
     */
    @TableId("id")
    private int id;

    @TableField("uid")
    private String uid;
    /**
     * 员工姓名
     */
    @TableField("name")
    private String name;
    /**
     * 员工性别
     */
    @TableField("sex")//'性别：0为男，1为女',
    private int sex;

    @TableField("nick_name")
    private String nick_name;// varchar(64) COMMENT '昵称',

    @TableField("level")
    private String level;//'用户等级',

    @TableField("job")
    private String job;// varchar(32) COMMENT '职业方向',

    @TableField("register_time")
    private String register_time;// 账户生成时间

    @TableField("update_time")
    private String update_time;// 账户生成时间
}
