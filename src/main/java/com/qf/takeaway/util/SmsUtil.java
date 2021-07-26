package com.qf.takeaway.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/6/25 11:03
 */
public class SmsUtil {
    public static void main(String[] args) {
        String code=SmsUtil.sendMsg("16639177029");
    }

    public static String sendMsg(String phoneNumber) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAI5tPsQq7pCRQ7ARUnGmQq", "DfgAzFCIEZoSVmA3U9usZHQ9ygLY44");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "阳阳商城");
        request.putQueryParameter("TemplateCode", "SMS_205409285");
        //验证码的参数必须是json数据格式
        //随机生成一个五位数的验证码
        String code = UUID.randomUUID().toString().substring(0, 5);//取前不去后
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        //调用ali的json包转换
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));

        try {
            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
            //判断请求是否成功
            String data=response.getData();
            //检验手机号码的准确性，还没写
            JSONObject jsonObject= JSON.parseObject(data);
            String code1 = jsonObject.getString("Code");
            if (code1.equalsIgnoreCase("OK")) {
                return code;
            }else {
                return null;
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "";
    }
}
