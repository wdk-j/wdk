package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFoodPics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Getter
@Setter
@ToString
public class TmsFoodWithMainPic {

    private static final long serialVersionUID = 1591171709422390836L;

    private TmsFoodPics mainPic;

    private Integer foodId;

    private Integer sales;

    @ApiModelProperty(value = "评分")
    private BigDecimal mark;

    @ApiModelProperty(value = "食品名称")
    private String foodName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "折扣")
    private BigDecimal discount;

    @ApiModelProperty(value = "包装费")
    private Double packingFee;

    @ApiModelProperty(value = "外键")
    private Integer sellerId;

    @ApiModelProperty(value = "是否上下架，1为下架")
    private String isOff;

    public TmsFoodWithMainPic() {
    }
}
