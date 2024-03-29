package com.store.storeservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storeservice.bean.db.TableUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<TableUser> {
    int updateByUid(@Param("user")TableUser tabUser);

}
