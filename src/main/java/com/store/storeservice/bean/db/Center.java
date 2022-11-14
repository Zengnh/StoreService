package com.store.storeservice.bean.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_organization_center")
public class Center {

    @TableField("id")
    public Long id;
    @TableField("name")
    public String name;
    @TableField("sn")
    public String sn;
}
