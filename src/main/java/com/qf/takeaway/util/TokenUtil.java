package com.qf.takeaway.util;

import java.util.UUID;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/7/4 10:14
 */
public class TokenUtil {
    //这里是根据时间戳生成的token，加个锁可以防止两个请求同时到这里
    public synchronized static String getToken(){
        String token1 = UUID.randomUUID().toString();
        String token = token1.replace("-", "");
        return token;
    }
}
