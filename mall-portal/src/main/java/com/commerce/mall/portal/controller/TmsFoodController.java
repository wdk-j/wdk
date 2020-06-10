package com.commerce.mall.portal.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.commerce.mall.portal.service.TmsFoodService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Controller
@Api(tags = {"TmsFoodController"}, description = "外卖的食品管理")
@RequestMapping("/food")
@Slf4j
public class TmsFoodController {

    @Autowired
    private TmsFoodCommentDetailService tmsFoodCommentDetailService;

    @Autowired
    private TmsFoodService tmsFoodService;

    @ApiOperation(value = "获取一个商品的详情")
    @GetMapping("/{foodId}")
    @ResponseBody
    public CommonResult<Object> foodDetails(@PathVariable("foodId") Integer foodId) {
        TmsFoodWithPics food = tmsFoodService.getFoodDetail(foodId);
        return CommonResult.success(food);
    }

    @ApiOperation("分页获取评论")
    @GetMapping("/comment/page")
    @ResponseBody
    public CommonResult<Object> pagedComments(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                              @RequestParam Integer foodId,
                                              @RequestParam(required = false,defaultValue = "3") String keyword) {
        int pageSize = 10;
        PageInfo<TmsFoodCommentDetail> list = tmsFoodCommentDetailService.pagedFoodCommentsInDetail(pageNum, pageSize, foodId, keyword);
        return CommonResult.success(list);
    }

    @ApiOperation(value = "分页获取一家店的商品")
    @GetMapping("/page")
    @ResponseBody
    public CommonResult<Object> pagedFoods(@RequestParam(required = false, defaultValue = "1") int pageNum) {
        // 强制
        int pageSize = 6;
        Integer sellerId = 1;
        PageInfo<TmsFoodWithMainPic> page = tmsFoodService.pagedHomeFoods(pageNum, pageSize, sellerId);
        return CommonResult.success(page);
    }
}
