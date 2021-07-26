package com.qf.takeaway.entity;

import java.io.Serializable;

/**
 * (Orderlist)实体类
 *
 * @author makejava
 * @since 2021-07-10 16:01:04
 */
public class Orderlist implements Serializable {
    private static final long serialVersionUID = -36121067174535300L;
    /**
     * 订单编号
     */
    private String oId;
    /**
     * 订单中的商品
     */
    private String goods;
    /**
     * 实付款
     */
    private String pay;


    public String getOId() {
        return oId;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

}
