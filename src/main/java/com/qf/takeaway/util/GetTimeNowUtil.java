package com.qf.takeaway.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/7/6 15:53
 */
public class GetTimeNowUtil {
    public static String getTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        return time;
    }
}
