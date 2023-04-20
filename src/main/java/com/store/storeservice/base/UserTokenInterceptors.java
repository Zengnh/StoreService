package com.store.storeservice.base;

import com.store.storeservice.bean.db.TableUser;
import com.store.storeservice.utils.ToolTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTokenInterceptors implements HandlerInterceptor {


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
          TableUser userinfo=ToolTokenManager.getInstance().getUInfoByToken(token);
            if(userinfo!=null){
                return true;
            }
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
