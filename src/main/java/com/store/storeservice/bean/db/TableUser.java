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
    /**      * 员工 id      */
    @TableId("id")
    private int id;

    @TableField("uid")
    private String uid;
    /**      * 员工姓名      */
    @TableField("name")
    private String name;
    /**      * 员工性别      */
    @TableField("sex")
    private String sex;
}
