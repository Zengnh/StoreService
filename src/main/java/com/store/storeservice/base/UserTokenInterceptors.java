package com.store.storeservice.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTokenInterceptors implements HandlerInterceptor {
//    @Autowired
//    private RedisTemplate redisTemplate;//注入redisTemplate

    public static final String TOKENID = "token ";//token的key统一前缀

    public static final long CACHE_TIME =7*24*60*60*1000;//redis过期时间 一周

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        if (((HandlerMethod) handler).hasMethodAnnotation(NoAuthoriztion.class)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token != null && !token.equals("")) {

//            直接跳过redis 校验token ，只要有token 就可以了
//            String key = TOKENID+token;
//            User user=(User) redisTemplate.opsForValue().get(key);//根据token 查询用户信息
//            if (user==null){
//                response.setStatus(401);//无权限
//                return true;
//            }
//            if (user != null) {
//                UserThreadLocal.set(user);
//            }
            return true;
        }
        response.setStatus(401);//无权限
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        UserThreadLocal.remove();
    }
}
