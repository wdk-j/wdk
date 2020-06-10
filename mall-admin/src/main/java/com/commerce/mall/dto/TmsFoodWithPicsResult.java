package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFoodPics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * 表示pc修改食品时的结果，
 * 多图，有销量，
 * 没有isOff和isDelete
 *
 * @author jiangyong
 * @date 2020.06.04
 */
@Getter
@Setter
@ToString
public class TmsFoodWithPicsResult {

    private static final long serialVersionUID = 5788675020116388439L;

    private List<TmsFoodPics> pics;

    private Integer sales;

    public TmsFoodWithPicsResult() {
    }

    private Integer foodId;

    @ApiModelProperty(value = "食品名称")
    private String foodName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "评分")
    private BigDecimal mark;

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
}
