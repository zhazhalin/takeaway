package com.qf.takeaway.result;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2021/6/24 15:06
 */
public enum ResponseCode {
    SUCCESS("200", "操作成功"),
    FAILED("999999","操作失败"),
    SQL_Exception("100","SQL异常"),
    STSYTEM_EXCEPTION("101","系统异常"),
    USERNAME_EXCEPTION("102","用户名异常"),
    PASSWORD_EXCEPTION("103","密码异常"),
    PARAMETER_EXCEPTION("104","参数异常"),
    AUTHTICATION_EXCEPTION("105","用户Token异常"),
    ParamError("000001", "参数错误！"),
    FileEmpty("000400","上传文件为空"),
    FileType("000403","文件类型错误"),
    LimitPictureSize("000401","图片大小必须小于2M"),
    LimitPictureType("000402","图片格式必须为'jpg'、'png'、'jpge'、'gif'、'bmp'")
    ;
    private String ecode;
    private String errorinfo;

    ResponseCode(String ecode, String errorinfo) {
        this.ecode = ecode;
        this.errorinfo = errorinfo;
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
}
