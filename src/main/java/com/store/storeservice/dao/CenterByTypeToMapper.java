package com.store.storeservice.dao;

import com.store.storeservice.bean.db.Center;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CenterByTypeToMapper {
    @Select("select id,name,sn from t_organization_center")
    List<Center> getList();
}
