package com.commerce.mall.custom.dto;

import com.commerce.mall.model.TmsFoodPics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author jiangyong
 * @date 2020.06.06
 */
@Getter
@Setter
@ToString
@Deprecated
public class TmsFoodWithMainPic {
    private static final long serialVersionUID = 437522082041119119L;

    private TmsFoodPics mainPic;

    private Integer sales;

    /**
     * 下面是food表的字段
     */
    private Integer foodId;

    public TmsFoodWithMainPic() {
    }

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

    @ApiModelProperty(value = "是否上下架，1为下架")
    private String isOff;

    @ApiModelProperty(value = "是否删除 1为删除")
    private String isDelete;

}
