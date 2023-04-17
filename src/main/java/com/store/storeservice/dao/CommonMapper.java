package com.store.storeservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CommonMapper {
    /**
     * 判断表是否存在
     *
     * @param tableName 表名称
     * @return 结果
     * @author yunnuo
     */
    @Select(" SELECT COUNT(*) as count FROM information_schema.TABLES WHERE table_name = #{tableName}")
    Integer existsTable(@Param("tableName") String tableName);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    void createAutoTaskResult(@Param("tableName")String tableName, @Param("cloums") List<String> cloums);

    /**
     * @Description: 单纯返回id作为key的map
     * @MapKey("id")
     * Map<Long, Object> selectTaskResult(@Param("tableName")String tableName, @Param("startDate")Date startDate, @Param("endDate")Date endDate)
     */

    List<Map<String, Object>> selectTaskResult(@Param("tableName")String tableName, @Param("startDate") Date startDate, @Param("endDate")Date endDate);


}