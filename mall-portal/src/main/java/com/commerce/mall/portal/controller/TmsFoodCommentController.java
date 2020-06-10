package com.commerce.mall.portal.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiangyong
 * @date 2020.06.11
 */
@RestController
@Api(tags = {"TmsFoodController"}, description = "外卖的评论管理")
@RequestMapping("/food/comment")
public class TmsFoodCommentController {

    private Logger log = LoggerFactory.getLogger(TmsFoodCommentController.class);

    @Autowired
    private TmsFoodCommentDetailService tmsFoodCommentDetailService;

    @ApiOperation("分页获取评论")
    @GetMapping("/page")
    public CommonResult<Object> pagedComments(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                              @RequestParam Integer foodId,
                                              @RequestParam(required = false,defaultValue = "3") String keyword) {
        int pageSize = 10;
        PageInfo<TmsFoodCommentDetail> list = tmsFoodCommentDetailService.pagedFoodCommentsInDetail(pageNum, pageSize, foodId, keyword);
        return CommonResult.success(list);
    }
}
