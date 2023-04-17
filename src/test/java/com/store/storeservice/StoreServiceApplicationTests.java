package com.store.storeservice;
import com.store.storeservice.bean.db.TableUser;
import com.store.storeservice.dao.CommonMapper;
import com.store.storeservice.dao.UserMapper;
import com.store.storeservice.utils.ToolTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StoreServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommonMapper commonMapper;

    @Test
    public void testSelect() {
        System.out.println("--------selectAll method test-------");
        //查询全部用户，参数是一个Wrapper，条件构造器，先不使用为null
        List<TableUser> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

        Integer integer = commonMapper.existsTable("data_20220601");
        System.out.println(integer);
    }

    @Test
    public void exeCheckTable() {

        Integer userResult = commonMapper.existsTable(ToolTable.user_info);
        if(userResult==1){
//            表存在
        }else{
            System.out.println("##########"+TableUser.class.getTypeName());

        }

        Integer tab2 = commonMapper.existsTable("textTable");
        if(tab2==1){
//            表存在
        }else{
            List<String> tabelNull=new ArrayList<>();
            tabelNull.add("age");
            tabelNull.add("size");
            commonMapper.createAutoTaskResult("textTable",tabelNull);
        }


    }
}
