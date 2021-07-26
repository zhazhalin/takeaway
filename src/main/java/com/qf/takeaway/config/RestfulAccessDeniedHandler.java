package com.qf.takeaway.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

//当访问接口没有权限时，自定义返回结果
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        PrintWriter writer = httpServletResponse.getWriter();
        HashMap<String,String> map =new HashMap<>();
        map.put("code","401");
        map.put("errorMsg","权限不足，联系管理员");

        writer.write(map.toString());
        writer.flush();
        writer.close();
    }
}
