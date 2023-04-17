package com.store.storeservice.controller;

import com.store.storeservice.bean.db.TableUser;
import com.store.storeservice.dao.CommonMapper;
import com.store.storeservice.utils.ToolTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableCheckController {
    @Autowired
    private CommonMapper commonMapper;

    @GetMapping("checkTable")
    public void checkTableInfo() {
        Integer userResult = commonMapper.existsTable(ToolTable.user_info);
        if (userResult == 1) {
//            表存在
            System.out.println("用户表：存在");
        } else {
//            commonMapper.createUserInfoTable();
        }

    }
}
