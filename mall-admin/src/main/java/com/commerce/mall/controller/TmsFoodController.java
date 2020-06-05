package com.commerce.mall.controller;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.common.utils.FileUtil;
import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.service.TmsFoodService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    public CommonResult<Object> listAllByKeyword(@RequestParam(required = false,defaultValue = "1") int pageNum,
                                                 @RequestParam(required = false,defaultValue = "5") int pageSize,
                                                 @RequestParam(required = false) String keyword) {
        PageInfo<TmsFoodWithMainPic> pagedFoods = tmsFoodService.listFoods(pageNum, pageSize, keyword);
        if (CollUtil.isEmpty(pagedFoods.getList())) {
            return CommonResult.failed("结果为空");
        }
        return CommonResult.success(pagedFoods);
    }


    @ApiOperation(value = "添加商品")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Object> addFood(@RequestParam(name = "files") MultipartFile[] files,
                                        TmsFood tmsFood) {
        List<String> urls = new ArrayList<>();
        //TODO 新增商品 图片上传
        for (MultipartFile file : files) {
            try {
                FileUtil.upload(file, "foods");
            } catch (IOException e) {
                return CommonResult.failed("文件上传错误");
            }
        }
        int i = tmsFoodService.add(tmsFood);
        if (i > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("添加失败");
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/update/{foodId}")
    @ResponseBody
    public CommonResult<Object> update(@PathVariable("foodId")Integer foodId, TmsFood tmsFood) {
        tmsFood.setFoodId(foodId);
        int i = tmsFoodService.update(tmsFood);
        if (i > 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("更新失败");
    }

    @ApiOperation(value = "根据id获取商品信息")
    @GetMapping("/{foodId}")
    @ResponseBody
    public CommonResult<Object> getOne(@PathVariable("foodId") Integer foodId) {
        TmsFoodWithMainPic food = tmsFoodService.get(foodId);
        return CommonResult.success(food);
    }
}
