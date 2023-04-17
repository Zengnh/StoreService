package com.store.storeservice.bean.db;

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
    @TableId("uid")
    private Long uid;
    /**      * 员工姓名      */
    private String name;
    /**      * 员工性别      */
    private String sex;
    /**      * 员工邮件      */
    private String email;
}
