package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TmsOrder implements Serializable {

    private Integer orderId;

    private Date postTime;

    private Integer addressId;

    private Integer userId;

    private Double packFee;

    private Double deliveryFee;

    private Double payment;

    private String memo;

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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}