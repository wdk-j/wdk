package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsAdvertising implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "广告介绍")
    private String adDesc;

    @ApiModelProperty(value = "图片url")
    private String picUrl;

    @ApiModelProperty(value = "是否删除，1为删除")
    private String isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdDesc() {
        return adDesc;
    }

    public void setAdDesc(String adDesc) {
        this.adDesc = adDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adDesc=").append(adDesc);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}