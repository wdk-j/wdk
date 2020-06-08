package com.commerce.mall.controller;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.model.TmsAdvertising;
import com.commerce.mall.service.TmsAdvertisingService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = {"TmsAdvertisingController"}, description = "广告管理")
@RequestMapping("/advertise")
@Slf4j
public class TmsAdvertisingController {

    @Autowired
    private TmsAdvertisingService tmsAdvertisingService;

    @ApiOperation(value = "添加广告")
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<Object> addAdvertising(@RequestBody TmsAdvertising tmsAdvertising){
        int rows = tmsAdvertisingService.add(tmsAdvertising);
        if (rows > 0) {
            return CommonResult.success(rows);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "修改广告")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult<Object> updateAdvertising(@PathVariable("id") Integer id , @RequestBody TmsAdvertising tmsAdvertising){
        tmsAdvertising.setId(id);
        int rows = tmsAdvertisingService.update(tmsAdvertising);
        if (rows > 0) {
            return CommonResult.success(rows);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "根据id获取广告信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<Object> getAdvertising(@PathVariable("id")Integer id){
        TmsAdvertising advertising = tmsAdvertisingService.get(id);
        return CommonResult.success(advertising);
    }

    @ApiOperation(value = "获取广告列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<Object> listAllByKeyword(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                                 @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                 @RequestParam(required = false) String keyword) {
        log.info("keyword: " + keyword);
        PageInfo<TmsAdvertising> pagedAdvertising = tmsAdvertisingService.listAdvertising(pageNum , pageSize , keyword);
        if (CollUtil.isEmpty(pagedAdvertising.getList())) {
            return CommonResult.failed("结果为空");
        }
        return CommonResult.success(pagedAdvertising);
    }

    @ApiOperation(value = "更新isDelete")
    @PostMapping("/update/isDelete")
    @ResponseBody
    public CommonResult<Object> updateAttrIsDelete(@RequestParam(required = false,defaultValue = "1") Integer id, @RequestParam String isDelete) {
        int rows = tmsAdvertisingService.updateAdIsDelete(isDelete , id);
        if (rows > 0) {
            return CommonResult.success(rows);
        }
        return CommonResult.failed("修改失败");
    }

    @ApiOperation(value = "批量上下架，更新isDelete")
    @PostMapping("/update/isDelete/batch")
    @ResponseBody
    public CommonResult<Object> updateIsDeleteInBatch(@RequestParam("ids") List<Integer> ids, @RequestParam("isDelete") String isDelete) {
        int rows = tmsAdvertisingService.updateAdIsDeleteInBatch(isDelete, ids);
        if (rows == ids.size()) {
            return CommonResult.success(rows);
        }
        return CommonResult.failed("批量修改失败");
    }
}
