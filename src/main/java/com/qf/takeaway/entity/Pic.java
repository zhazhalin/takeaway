package com.qf.takeaway.entity;

import java.io.Serializable;

/**
 * (Pic)实体类
 *
 * @author makejava
 * @since 2021-07-06 11:21:49
 */
public class Pic implements Serializable {
    private static final long serialVersionUID = -59433245915682813L;
    /**
     * 轮播图片id
     */
    private String pId;
    /**
     * 图片url
     */
    private String url;
    /**
     * 图片类型(1、shop 2、goods 3、lb)
     */
    private String type;
    /**
     * 轮播图状态 0未启用1启用
     */
    private String status;


    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
