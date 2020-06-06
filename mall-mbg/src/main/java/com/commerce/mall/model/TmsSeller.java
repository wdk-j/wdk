package com.commerce.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class TmsSeller implements Serializable {
    private Integer sellerId;

    @ApiModelProperty(value = "卖家名称")
    private String sellerName;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "卖家Logo")
    private String logoUrl;

    @ApiModelProperty(value = "卖家地址ID")
    private Long addrId;

    @ApiModelProperty(value = "起送价格")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "是否打烊：1打烊，0未打烊")
    private String closed;

    @ApiModelProperty(value = "是否删除：0未删除，1删除")
    private String isDelete;

    @ApiModelProperty(value = "卖家介绍")
    private String intro;

    private static final long serialVersionUID = 1L;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", tel=").append(tel);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", addrId=").append(addrId);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", closed=").append(closed);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", intro=").append(intro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}