package com.commerce.mall.portal.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.model.TmsAdvertising;
import com.commerce.mall.portal.service.TmsAdvertisingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.09
 */
@RestController
@RequestMapping("/advertising")
@Api(tags = "TmsAdvertisingController", description = "广告管理")
public class TmsAdvertisingController {

    @Autowired
    private TmsAdvertisingService tmsAdvertisingService;

    @ApiOperation("获取广告列表")
    @GetMapping("/list")
    public CommonResult<Object> list() {
        List<TmsAdvertising> list = tmsAdvertisingService.list();
        return CommonResult.success(list);
    }
}
