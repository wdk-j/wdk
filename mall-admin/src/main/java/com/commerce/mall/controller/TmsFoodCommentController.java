package com.commerce.mall.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.dto.TmsFoodCommentDetail;
import com.commerce.mall.service.TmsFoodCommentsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Controller
@Api(tags = "TmsFoodCommentController", description = "商品（食品）评论管理")
@RequestMapping("/food")
@Slf4j
public class TmsFoodCommentController {

    @Autowired
    private TmsFoodCommentsService tmsFoodCommentsService;

    @ApiOperation("分页-以关键词获取食物评论")
    @GetMapping("/comment/list")
    @ResponseBody
    public CommonResult<Object> pagedList(@RequestParam(required = false,defaultValue = "1")Integer sellerId,
                                          @RequestParam(required = false,defaultValue = "1")int pageNum,
                                          @RequestParam(required = false,defaultValue = "1")int pageSize,
                                          @RequestParam(required = false) String keyword) {
        sellerId=1;
        PageInfo<TmsFoodCommentDetail> list = tmsFoodCommentsService.pagedList(pageNum, pageSize, keyword, sellerId);
        return CommonResult.success(list);
    }

    @ApiOperation("店家回复评论")
    @GetMapping("/comment/update/{commId}")
    @ResponseBody
    public CommonResult<Object> sellerReplyComment(@PathVariable("commId") Integer commId, String reply) {
        int i = tmsFoodCommentsService.reply(commId, reply);
        if (i > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("评论失败");
    }
}
