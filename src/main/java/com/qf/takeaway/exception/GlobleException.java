package com.qf.takeaway.exception;

import com.alibaba.fastjson.JSONObject;
import com.qf.takeaway.result.ResponseCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/7/4 9:23
 * 处理全局异常的地方
 */
@Component
public class GlobleException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        JSONObject jsonObject=new JSONObject();
        //处理各种异常
        if(e instanceof BusinessException){
            BusinessException businessException=(BusinessException)e;
            jsonObject.put("code",businessException.getCode());
            jsonObject.put("errorinfo",businessException.getMessage());
        }else if(e instanceof SQLException){
            jsonObject.put("code", ResponseCode.SQL_Exception.getEcode());
            jsonObject.put("errorinfo", ResponseCode.SQL_Exception.getErrorinfo());
        }else {
            jsonObject.put("code",ResponseCode.STSYTEM_EXCEPTION.getEcode());
            jsonObject.put("errorinfo",ResponseCode.STSYTEM_EXCEPTION.getErrorinfo());
        }
        //将数据返回到客户端
        httpServletResponse.setContentType("text/html;charset=utf-8");
        try {
            httpServletResponse.getWriter().write(jsonObject.toString());
            httpServletResponse.getWriter().flush();
            httpServletResponse.getWriter().close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
