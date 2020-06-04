package com.commerce.mall.portal.controller;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.domain.TmsFoodDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.commerce.mall.portal.service.TmsFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Controller
@Api(tags = {"TmsFoodController"},description = "外卖的食品管理")
@RequestMapping("/food")
public class TmsFoodController {

    @Autowired
    private TmsFoodCommentDetailService tmsFoodCommentDetailService;

    @Autowired
    private TmsFoodService tmsFoodService;

    @ApiOperation(value = "获取一个商品的详情和它的所有评论")
    @GetMapping("/{foodId}")
    @ResponseBody
    public CommonResult<Object> foodDetails(@PathVariable("foodId")Integer foodId) {
        TmsFoodDetail food = tmsFoodService.getFoodDetail(foodId);
        List<TmsFoodCommentDetail> comments = tmsFoodCommentDetailService.listFoodCommentsInDetail(foodId);
        Map<String, Object> map = new HashMap<>(2);
        map.put("food", food);
        map.put("comments", comments);
        return CommonResult.success(map);
    }

}
