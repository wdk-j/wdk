package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class TmsFood implements Serializable {
    private Integer foodId;

    @ApiModelProperty(value = "食品名称")
    private String foodName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;

    @ApiModelProperty(value = "主料")
    private String mainMaterials;

    @ApiModelProperty(value = "荤素")
    private String hasMeat;

    @ApiModelProperty(value = "重量")
    private Double weight;

    @ApiModelProperty(value = "卖家描述")
    private String intro;

    @ApiModelProperty(value = "包装费")
    private Double packingFee;

    @ApiModelProperty(value = "外键")
    private Integer sellerId;

    @ApiModelProperty(value = "是否上下架，1为下架")
    private String isOff;

    @ApiModelProperty(value = "是否删除 1为删除")
    private String isDelete;

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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(Double packingFee) {
        this.packingFee = packingFee;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getIsOff() {
        return isOff;
    }

    public void setIsOff(String isOff) {
        this.isOff = isOff;
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
        sb.append(", foodId=").append(foodId);
        sb.append(", foodName=").append(foodName);
        sb.append(", price=").append(price);
        sb.append(", discount=").append(discount);
        sb.append(", mainMaterials=").append(mainMaterials);
        sb.append(", hasMeat=").append(hasMeat);
        sb.append(", weight=").append(weight);
        sb.append(", intro=").append(intro);
        sb.append(", packingFee=").append(packingFee);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", isOff=").append(isOff);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}