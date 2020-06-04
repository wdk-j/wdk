package com.commerce.mall.portal.controller;


import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.portal.domain.TmsFoodInHome;
import com.commerce.mall.portal.service.impl.TmsSellerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Controller
@Api(tags = {"TmsSellerController"}, description = "卖家店铺管理")
@RequestMapping("/seller")
public class TmsSellerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmsSellerController.class);

    @Autowired
    private TmsSellerServiceImpl tmsSellerService;

    @ApiOperation(value = "获取一家店的所有商品", notes = "what is notes?")
    @GetMapping("/foods")
    @ResponseBody
    public CommonResult<Object> getFoodsList(@Validated @RequestParam("sellerId") Integer sellerId) {
        // 强制
        // sellerId=1;
        LOGGER.info("seller id: " + sellerId + "homeFoodList".toString());
        List<TmsFoodInHome> homeFoodList = tmsSellerService.listHomeFoods(sellerId);
        return CommonResult.success(homeFoodList);
    }
}