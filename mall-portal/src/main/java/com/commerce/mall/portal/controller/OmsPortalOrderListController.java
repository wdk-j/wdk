package com.commerce.mall.portal.controller;


import com.commerce.mall.common.api.CommonPage;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.model.OmsOrder;
import com.commerce.mall.portal.service.OmsPortalOrderListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "OmsPortalOrderListController", description = "订单列表管理")
@RequestMapping("/orderList")
public class OmsPortalOrderListController {
    @Autowired
    private OmsPortalOrderListService portalOrderListService;

    @ApiOperation("查询全部订单")
    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getAllList(Long userId, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderListService.getAllList(userId,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));

    }
    @ApiOperation("查询订单")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getAllList(Long userId, int status, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderListService.getList(userId, status, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));

    }
}
