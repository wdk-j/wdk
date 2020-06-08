package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TmsFoodComments implements Serializable {
    private Integer commId;

    @ApiModelProperty(value = "是否好评，1为好评")
    private String nice;

    @ApiModelProperty(value = "评论时间")
    private Date postTime;

    @ApiModelProperty(value = "评论人ID")
    private Integer userId;

    @ApiModelProperty(value = "食物ID")
    private Integer foodId;

    @ApiModelProperty(value = "答复")
    private String reply;

    @ApiModelProperty(value = "评论内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getNice() {
        return nice;
    }

    public void setNice(String nice) {
        this.nice = nice;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commId=").append(commId);
        sb.append(", nice=").append(nice);
        sb.append(", postTime=").append(postTime);
        sb.append(", userId=").append(userId);
        sb.append(", foodId=").append(foodId);
        sb.append(", reply=").append(reply);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}