package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFoodCommentsPics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Getter
@Setter
@ToString
public class TmsFoodCommentDetail {

    private String nickname;

    private String icon;

    private List<TmsFoodCommentsPics> commPics;

    private static final long serialVersionUID = -5850708712994633469L;

    private Integer commId;

    @ApiModelProperty(value = "是否好评，1为好评")
    private String nice;

    @ApiModelProperty(value = "评论时间")
    private Date postTime;

    @ApiModelProperty(value = "评论人ID")
    private Integer userId;

    @ApiModelProperty(value = "食物ID")
    private Integer foodId;

    @ApiModelProperty(value = "答复")
    private String reply;

    @ApiModelProperty(value = "评论内容")
    private String content;
}
