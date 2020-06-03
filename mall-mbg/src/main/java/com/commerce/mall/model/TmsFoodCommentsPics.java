package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class TmsFoodCommentsPics implements Serializable {

    private Integer picId;

    @ApiModelProperty(value = "图片网络地址")
    private String picUrl;

    private String picDesc;

    private Integer commId;

    private static final long serialVersionUID = 1L;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", picId=").append(picId);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", picDesc=").append(picDesc);
        sb.append(", commId=").append(commId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}