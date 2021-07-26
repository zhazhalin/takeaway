package com.qf.takeaway.exception;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/7/4 9:21
 * 业务异常
 */
public class BusinessException extends  RuntimeException{
    private String code;  //出错的状态码
    private String message;  //出错时候的消息提示

    public BusinessException(String ecode, String message) {
        this.code=ecode;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
