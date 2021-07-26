package com.qf.takeaway.entity;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-07-06 16:31:51
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = 539080867539111062L;
    /**
     * 商品id
     */
    private String gId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品图片id
     */
    private String pic;
    /**
     * 商品销售量
     */
    private String number;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 商品对应的商家id
     */
    private String sId;
    /**
     * 类目信息（分类）
     */
    private String classifyname;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname;
    }
}
