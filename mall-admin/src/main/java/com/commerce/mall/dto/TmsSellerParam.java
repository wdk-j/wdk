package com.commerce.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author jiangyong
 * @date 2020.06.08
 */
@Setter
@Getter
@ToString
public class TmsSellerParam {

    private Integer sellerId;

    @ApiModelProperty(value = "卖家名称")
    private String sellerName;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "卖家Logo")
    private String logoUrl;

    @ApiModelProperty(value = "卖家详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "起送价格")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "是否打烊：1打烊，0未打烊")
    private String closed;

    @ApiModelProperty(value = "是否删除：0未删除，1删除")
    private String isDelete;

    @ApiModelProperty(value = "卖家介绍")
    private String intro;
}
