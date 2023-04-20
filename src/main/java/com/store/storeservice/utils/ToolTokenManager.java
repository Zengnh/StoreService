package com.store.storeservice.utils;

import com.store.storeservice.bean.db.TableUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

/**
 * token 管理
 * redis:正式环境需要变更成使用redis方式存储token，获取token
 */
public class ToolTokenManager {
    private ToolTokenManager() {
    }

    private static ToolTokenManager instance;

    public static ToolTokenManager getInstance() {
        if (instance == null) {
            instance = new ToolTokenManager();
        }
        return instance;
    }


        @Autowired
    private RedisTemplate redisTemplate;//注入redisTemplate

    private HashMap<String, TableUser> userTokenMap = new HashMap<>();

    public TableUser getUInfoByToken(String token) {

//                    直接跳过redis 校验token ，只要有token 就可以了
//            String key = TOKENID+token;
//            User user=(User) redisTemplate.opsForValue().get(key);//根据token 查询用户信息
//            if (user==null){
//                response.setStatus(401);//无权限
//                return true;
//            }
//            if (user != null) {
//                UserThreadLocal.set(user);
//            }

        if (userTokenMap.containsKey(token)) {
            return userTokenMap.get(token);
        }
        return null;
    }

    public void setUInfoByToken(String token, TableUser user) {
        userTokenMap.put(token, user);
    }

    public void reflushToken(String oldToken, String newToken) {
        TableUser userInfo = userTokenMap.get(oldToken);
        userTokenMap.put(newToken, userInfo);
        userTokenMap.remove(oldToken);
    }

}
