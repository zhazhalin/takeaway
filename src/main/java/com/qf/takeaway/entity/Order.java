package com.qf.takeaway.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-07-06 15:38:44
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -27299942885997569L;
    /**
     * 订单编号
     */
    private String oId;
    /**
     * 下单姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 送达时间
     */
    private String sendtime;
    /**
     * 商家地址信息
     */
    private String saddress;
    /**
     * 用户地址信息
     */
    private String uaddress;
    /**
     * 订单创建时间
     */
    private String creattime;
    /**
     * 订单总金额
     */
    private Integer totleprice;
    /**
     * 下单商品
     */
    private String ordergoods;
    /**
     * 下单用户昵称
     */
    private String nickname;
    /**
     * 订单完成状态
     */
    private String status;
    /**
     * 订单完成时间
     */
    private String finishtime;
    /**
     * 备注信息
     */
    private String desc;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Order() {
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public Integer getTotleprice() {
        return totleprice;
    }

    public void setTotleprice(Integer totleprice) {
        this.totleprice = totleprice;
    }

    public String getOrdergoods() {
        return ordergoods;
    }

    public void setOrdergoods(String ordergoods) {
        this.ordergoods = ordergoods;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
