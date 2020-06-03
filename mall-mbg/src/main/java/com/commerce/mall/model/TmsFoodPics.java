package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsFoodPics implements Serializable {
    private Integer picId;

    @ApiModelProperty(value = "图片网络地址")
    private String picUrl;

    private String picDesc;

    @ApiModelProperty(value = "是否为主图")
    private String isMain;

    private Integer foodId;

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

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
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
        sb.append(", isMain=").append(isMain);
        sb.append(", foodId=").append(foodId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}