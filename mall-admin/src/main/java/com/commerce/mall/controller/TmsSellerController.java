package com.commerce.mall.controller;

import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.common.api.ResultCode;
import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.service.TmsSellerService;
import com.commerce.mall.service.impl.TmsSellerServiceImpl;
import io.minio.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = {"TmsSellerController"},description = "商家管理")
@RequestMapping("/seller")
public class TmsSellerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmsSellerController.class);

    @Autowired
    private TmsSellerServiceImpl tmsSellerService;

    @ApiOperation(value = "根据商家id查询商家信息")
    @GetMapping("/seller/{sellerId}")
    @ResponseBody
    public CommonResult<Object> getSellers(@Validated @PathVariable("sellerId") Integer sellerId){
        TmsSeller tmsSellerById = tmsSellerService.getTmsSellerById(sellerId);
        LOGGER.info("seller id: " + sellerId + tmsSellerById.toString());
        return CommonResult.success(tmsSellerById);
    }


    @ApiOperation(value = "添加商家")
    @PostMapping("/seller/add")
    @ResponseBody
    public void addSeller(@Validated @PathVariable("tmsSeller") TmsSeller tmsSeller){
        tmsSellerService.addTmsSeller(tmsSeller);
    }

    @ApiOperation(value = "根据商家Id修改商家信息")
    @PostMapping("/seller/update/{sellerId}")
    @ResponseBody
    public CommonResult<Object> updateSeller(@Validated @PathVariable("sellerId") TmsSeller tmsSeller){
        int i = tmsSellerService.updateTmsSeller(tmsSeller);
        return CommonResult.success(1);
    }

}
