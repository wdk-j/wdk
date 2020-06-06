package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TmsOrder implements Serializable {
    private Integer orderId;

    @ApiModelProperty(value = "提交时间")
    private Date postTime;

    @ApiModelProperty(value = "配送地址外键")
    private Integer addressId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "包装费")
    private Double packFee;

    @ApiModelProperty(value = "配送费")
    private Double deliveryFee;

    @ApiModelProperty(value = "实付金额")
    private Double payment;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "优惠券外键")
    private Integer couponId;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", postTime=").append(postTime);
        sb.append(", addressId=").append(addressId);
        sb.append(", userId=").append(userId);
        sb.append(", packFee=").append(packFee);
        sb.append(", deliveryFee=").append(deliveryFee);
        sb.append(", payment=").append(payment);
        sb.append(", memo=").append(memo);
        sb.append(", couponId=").append(couponId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}