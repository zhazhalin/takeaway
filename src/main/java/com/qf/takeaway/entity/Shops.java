package com.qf.takeaway.entity;

import java.io.Serializable;

/**
 * (Shops)实体类
 *
 * @author makejava
 * @since 2021-07-06 10:39:21
 */
public class Shops implements Serializable {
    private static final long serialVersionUID = -87702586789668249L;
    /**
     * 商家id
     */
    private String sId;
    /**
     * 商家图片id
     */
    private String sImg;
    /**
     * 商家距离
     */
    private Integer sDistance;
    /**
     * 商家销售额
     */
    private String sSales;
    /**
     * 商家logo
     */
    private String sLogo;
    /**
     * 商家名字
     */
    private String sName;
    /**
     * 商家描述
     */
    private String sDesc;
    /**
     * 商家类型
     */
    private String sTitle;
    /**
     * 店铺评分
     */
    private String sScore;
    /**
     * 店铺地址
     */
    private String sAddress;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }

    public Integer getsDistance() {
        return sDistance;
    }

    public void setsDistance(Integer sDistance) {
        this.sDistance = sDistance;
    }

    public String getsSales() {
        return sSales;
    }

    public void setsSales(String sSales) {
        this.sSales = sSales;
    }

    public String getsLogo() {
        return sLogo;
    }

    public void setsLogo(String sLogo) {
        this.sLogo = sLogo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsScore() {
        return sScore;
    }

    public void setsScore(String sScore) {
        this.sScore = sScore;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }
}
