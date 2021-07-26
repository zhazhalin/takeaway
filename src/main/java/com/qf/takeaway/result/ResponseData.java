package com.qf.takeaway.result;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/6/24 14:56
 */
public class ResponseData {
    private String ecode;
    private String errorinfo;
    private Object data;
    private Integer count;

    public ResponseData() {
    }

    public ResponseData(String ecode, String errorinfo, Object data) {
        this.ecode = ecode;
        this.errorinfo = errorinfo;
        this.data = data;
    }
    public ResponseData(String ecode, String errorinfo, Object data, Integer count) {
        this.ecode = ecode;
        this.errorinfo = errorinfo;
        this.data = data;
        this.count = count;
    }
    public ResponseData(String ecode, String errorinfo) {
        this.ecode = ecode;
        this.errorinfo = errorinfo;
    }
    public ResponseData(ResponseCode responseCode, Object data) {
        this.data=data;
        this.ecode=responseCode.getEcode();
        this.errorinfo=responseCode.getErrorinfo();
    }
    public ResponseData(ResponseCode responseCode) {
        this.ecode=responseCode.getEcode();
        this.errorinfo=responseCode.getErrorinfo();
    }
    public ResponseData(Object object) {
        this.ecode=ResponseCode.SUCCESS.getEcode();
        this.errorinfo=ResponseCode.SUCCESS.getErrorinfo();
        this.data=object;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
