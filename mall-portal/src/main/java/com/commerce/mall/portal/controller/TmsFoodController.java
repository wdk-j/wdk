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
@Api(tags = {"TmsFoodController"},description = "外卖的食品管理")
@RequestMapping("/food")
@Slf4j
public class TmsFoodController {

    @Autowired
    private TmsFoodCommentDetailService tmsFoodCommentDetailService;

    @Autowired
    private TmsFoodService tmsFoodService;

    @ApiOperation(value = "获取一个商品的详情和它的所有评论")
    @GetMapping("/{foodId}")
    @ResponseBody
    public CommonResult<Object> foodDetails(@PathVariable("foodId")Integer foodId) {
        TmsFoodWithPics food = tmsFoodService.getFoodDetail(foodId);
        List<TmsFoodCommentDetail> comments = tmsFoodCommentDetailService.listFoodCommentsInDetail(foodId);
        Map<String, Object> map = new HashMap<>(2);
        map.put("food", food);
        map.put("comments", comments);
        return CommonResult.success(map);
    }

    @ApiOperation(value = "获取一家店的所有商品", notes = "what is notes?")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<Object> getFoodsList(@RequestParam(required = false,defaultValue = "1")Integer sellerId) {
        // 强制
        sellerId=1;
        List<TmsFoodWithMainPic> homeFoodList = tmsFoodService.listHomeFoods(sellerId);
        log.info("seller id: " + sellerId + homeFoodList.toString());
        return CommonResult.success(homeFoodList);
    }

    @ApiOperation(value = "分页获取一家店的商品")
    @GetMapping("/page")
    @ResponseBody
    public CommonResult<Object> pagedFoods(@RequestParam(required = false,defaultValue = "1")int pageNum) {
        // 强制
        int pageSize=6;
        Integer sellerId=1;
        PageInfo<TmsFoodWithMainPic> page = tmsFoodService.pagedHomeFoods(pageNum, pageSize, sellerId);
        return CommonResult.success(page);
    }
}
