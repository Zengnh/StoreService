package com.store.storeservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storeservice.base.Result;
import com.store.storeservice.bean.db.Account;
import com.store.storeservice.bean.db.TableUser;
import com.store.storeservice.bean.dto.DTOLogin;
import com.store.storeservice.bean.vo.VOUserInfo;
import com.store.storeservice.dao.AccountMapper;
import com.store.storeservice.dao.CommonMapper;
import com.store.storeservice.dao.UserMapper;
import com.store.storeservice.utils.ToolTokenManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(tags = "用户属性相关")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;

    //    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
//    produces 对应请求 Content-Type
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("获取ip地址跟端口号")
    @ResponseBody
    @PostMapping(value = {"/login"}, produces = "application/json;charset=UTF-8")
    public Result<VOUserInfo> loginConfig(@Validated @RequestBody DTOLogin login) {
//        List<Center> data=centerByTypeToMapper.getList();
        QueryWrapper queryWrapper = new QueryWrapper<Account>();
//        queryWrapper.eq("pwd", login.getPassword());
//        queryWrapper.eq("type", login.getType());
        queryWrapper.eq("account", login.getAccount());
        Account account = accountMapper.selectOne(queryWrapper);
        if (account == null || account.getId() == 0) {
            account = new Account();
            account.setUid(UUID.randomUUID().toString());
            account.setType(login.getType());
            account.setAccount(login.getAccount());
            account.setPwd(login.getPassword());
//            插入一条数据
//            accountMapper.insterAccount(account);
            accountMapper.insert(account);
            String token = UUID.randomUUID().toString();
            TableUser userResult = new TableUser();
            userResult.setUid(account.getUid());
            ToolTokenManager.getInstance().setUInfoByToken(token, userResult);
            userMapper.insert(userResult);
            VOUserInfo result = new VOUserInfo();
            result.setUserInfo(userResult);
            result.access_token = token;
            return Result.succeed(result);
        } else {
            if (account.getPwd().equals(login.getPassword())) {
                QueryWrapper user = new QueryWrapper<TableUser>();
                queryWrapper.eq("uid", account.getUid());
                TableUser userResult = userMapper.selectOne(user);
                String token = UUID.randomUUID().toString();
                ToolTokenManager.getInstance().setUInfoByToken(token, userResult);
                VOUserInfo result = new VOUserInfo();
                result.setUserInfo(userResult);
                result.access_token = token;
                return Result.succeed(result);
            } else {
                return Result.failed("密码错误");
            }
        }

    }

    @ResponseBody
    @PostMapping(value = {"/setUserInfo"}, produces = "application/json;charset=UTF-8")
    public Result<String> setUserInfo(@Validated @RequestBody VOUserInfo userInfo) {
        int upLine = 0;
        if (userInfo != null) {
            TableUser tabUser = new TableUser();
            tabUser.setUid(userInfo.uid);
            tabUser.setName(userInfo.name);
            tabUser.setSex(userInfo.sex);
            tabUser.setLevel(1 + "");
            tabUser.setNick_name(userInfo.nick_name);
            tabUser.setRegister_time(System.currentTimeMillis() + "");
            upLine = userMapper.updateByUid(tabUser);
        }
        if (upLine == 0) {
            return Result.failed("更新失败");
        } else {
            return Result.succeed("更新完成");
        }

    }

    @Autowired
    CommonMapper commonMapper;

    @ResponseBody
    @GetMapping(value = {"/text"}, produces = "application/json;charset=UTF-8")
    public Result<TableUser> textTc() {
//        List<String> tabelNull=new ArrayList<>();
//        tabelNull.add("age");
//        tabelNull.add("size");
//        commonMapper.createAutoTaskResult("textTable",tabelNull);

        return Result.succeed(userMapper.selectById(1));
    }


}