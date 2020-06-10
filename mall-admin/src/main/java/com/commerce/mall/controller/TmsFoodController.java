package com.commerce.mall.controller;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.dto.TmsFoodWithPicsResult;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.service.TmsFoodService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Controller
@Api(tags = "TmsFoodController", description = "商品（食品）管理")
@RequestMapping("/food")
@Slf4j
public class TmsFoodController {

    @Autowired
    private TmsFoodService tmsFoodService;

    @ApiOperation(value = "获取商品列表，可带关键字")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<Object> listAllByKeyword(@RequestParam(required = false, defaultValue = "1") Integer sellerId,
                                                 @RequestParam(required = false, defaultValue = "1") int pageNum,
                                                 @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                 @RequestParam(required = false) String keyword) {
        log.info("keyword: " + keyword);
        PageInfo<TmsFoodWithMainPic> pageInfo = tmsFoodService.listFoods(pageNum, pageSize, sellerId, keyword);
        if (CollUtil.isEmpty(pageInfo.getList())) {
            return CommonResult.failed("结果为空");
        }
        return CommonResult.success(pageInfo);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping(value = "/add")
    @ResponseBody
    public CommonResult<Object> addFood(@RequestBody TmsFoodWithPicsResult tmsFoodWithPicsResult) {
        // 默认卖家1
        tmsFoodWithPicsResult.setSellerId(1);
        int i = tmsFoodService.add(tmsFoodWithPicsResult);
        if (i > 0) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("添加失败");
    }

    @ApiOperation(value = "上下架食品，更新isOff")
    @PostMapping("/update/isOff")
    @ResponseBody
    public CommonResult<Object> updateIsOff(@RequestParam("foodId") Integer foodId, @RequestParam("isOff") String isOff) {
        int i = tmsFoodService.updateAttrIsDelete(isOff, foodId);
        if (i > 0) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation(value = "批量上下架食品，更新isOff")
    @PostMapping("/update/isOff/batch")
    @ResponseBody
    public CommonResult<Object> updateIsOffInBatch(@RequestParam("foodIds") List<Integer> foodIds, @RequestParam("isOff") String isOff) {
        int i = tmsFoodService.updateAttrIsOffInBatch(isOff, foodIds);
        if (i == foodIds.size()) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("批量修改失败");
    }

    @ApiOperation(value = "删除食品，更新isDelete")
    @PostMapping("/update/isDelete")
    @ResponseBody
    public CommonResult<Object> updateIsDelete(@RequestParam("foodId") Integer foodId, @RequestParam("isDelete") String isDelete) {
        int i = tmsFoodService.updateAttrIsDelete(isDelete, foodId);
        if (i > 0) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation(value = "批量删除食品，更新isDelete")
    @PostMapping("/update/isDelete/batch")
    @ResponseBody
    public CommonResult<Object> updateIsDeleteInBatch(@RequestParam("foodIds") List<Integer> foodIds, @RequestParam("isDelete") String isDelete) {
        int i = tmsFoodService.updateAttrIsDeleteInBatch(isDelete, foodIds);
        if (i == foodIds.size()) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("批量修改失败");
    }

    @ApiOperation(value = "更新商品")
    @PostMapping("/update/{foodId}")
    @ResponseBody
    public CommonResult<Object> update(@PathVariable("foodId") Integer foodId, @RequestBody TmsFoodWithPicsResult tmsFoodWithPicsResult) {
        tmsFoodWithPicsResult.setFoodId(foodId);
        int i = tmsFoodService.update(tmsFoodWithPicsResult);
        if (i > 0) {
            return CommonResult.success(i);
        }
        return CommonResult.failed("更新失败");
    }

    @ApiOperation(value = "根据id获取商品信息")
    @GetMapping("/{foodId}")
    @ResponseBody
    public CommonResult<Object> getOne(@PathVariable("foodId") Integer foodId) {
        TmsFoodWithPicsResult food = tmsFoodService.get(foodId);
        return CommonResult.success(food);
    }
}
