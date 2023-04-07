package com.store.storeservice.exception;

import com.store.storeservice.base.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 全局异常处理
 */
@ControllerAdvice
public class JMSExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        e.printStackTrace();
//        StringBuilder sb = new StringBuilder();
//        sb.append("请求接口：").append(ServletUtils.getRequest().getRequestURI()).append("\n");
//        sb.append("请求参数：").append(JSONObject.toJSON(ServletUtils.getRequest().getParameterMap())).append("\n");
//        sb.append("异常原因：").append(ExceptionUtils.getExceptionAllInformation(e)).append("\n");
//        if(e instanceof BusinessException) {
//            BusinessException e2 = (BusinessException)e;
//            return Result.failedWith(null, e2.getStatusCode(), e2.getBusinessMessage());
//        }else {
////            pushService.pushDingTalkMessage(sb.toString().length() > 1000 ? sb.toString().substring(0,1000) : sb.toString());
//            return Result.failed("系统异常");
//        }
        return Result.failed("系统异常：" + e.getMessage());
    }
}
