package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class TmsFood implements Serializable {
    private Integer foodId;

    @ApiModelProperty(value = "食物名称")
    private String foodName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "食品评分")
    private BigDecimal mark;

    @ApiModelProperty(value = "销售量")
    private Integer sales;

    @ApiModelProperty(value = "主料")
    private String mainMaterials;

    @ApiModelProperty(value = "荤素")
    private String hasMeat;

    @ApiModelProperty(value = "重量")
    private Double weight;

    @ApiModelProperty(value = "外键")
    private Integer sellerId;

    private static final long serialVersionUID = 1L;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMark() {
        return mark;
    }

    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getMainMaterials() {
        return mainMaterials;
    }

    public void setMainMaterials(String mainMaterials) {
        this.mainMaterials = mainMaterials;
    }

    public String getHasMeat() {
        return hasMeat;
    }

    public void setHasMeat(String hasMeat) {
        this.hasMeat = hasMeat;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", foodId=").append(foodId);
        sb.append(", foodName=").append(foodName);
        sb.append(", price=").append(price);
        sb.append(", mark=").append(mark);
        sb.append(", sales=").append(sales);
        sb.append(", mainMaterials=").append(mainMaterials);
        sb.append(", hasMeat=").append(hasMeat);
        sb.append(", weight=").append(weight);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}