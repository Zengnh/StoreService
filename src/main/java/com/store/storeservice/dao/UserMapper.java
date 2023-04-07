package com.store.storeservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storeservice.bean.db.Center;
import com.store.storeservice.bean.vo.VOUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<Center> {
    //    crud
    Integer countCenter();
    VOUserInfo getUserInfo(@Param("userid")String userId);
}
