package com.store.storeservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storeservice.bean.db.Account;
import com.store.storeservice.bean.db.TableUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface AccountMapper extends BaseMapper<Account> {


//    int batchInsertBook(@Param("list") List<IcafeProductLineCard> recordList);
    int insterAccount(@Param("account") Account account);

}