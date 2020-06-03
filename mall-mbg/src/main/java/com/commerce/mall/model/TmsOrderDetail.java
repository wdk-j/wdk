package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TmsOrderDetail implements Serializable {
    private Integer odId;

    private Integer foodId;

    private Integer orderId;

    private String amount;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
        sb.append(", odId=").append(odId);
        sb.append(", foodId=").append(foodId);
        sb.append(", orderId=").append(orderId);
        sb.append(", amount=").append(amount);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}