package com.commerce.mall.portal.controller;

import com.commerce.mall.common.api.CommonPage;
import com.commerce.mall.common.api.CommonResult;
import com.commerce.mall.model.OmsOrder;
import com.commerce.mall.portal.domain.ConfirmOrderResult;
import com.commerce.mall.portal.domain.OrderParam;
import com.commerce.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 订单管理Controller
 * Created by commerce on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("根据购物车信息生成确认单信息")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder() {
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = portalOrderService.generateOrder(orderParam);
        return CommonResult.success(result, "下单成功");
    }

    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult paySuccess(@RequestParam Long orderId) {
        Integer count = portalOrderService.paySuccess(orderId);
        return CommonResult.success(count, "支付成功");
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelTimeOutOrder() {
        portalOrderService.cancelTimeOutOrder();
        return CommonResult.success(null);
    }
    @ApiOperation("查询全部订单")
    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getAllList(Long userId,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderService.getAllList(userId,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
    @ApiOperation("查询待付款订单")
    @RequestMapping(value = "/getNoPayList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getNoPayList(Long userId,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderService.getNoPayList(userId,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
    @ApiOperation("查询待收货订单")
    @RequestMapping(value = "/getNoReceivedList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getNoReceived(Long userId,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderService.getNoReceivedList(userId,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
    @ApiOperation("查询待评价订单")
    @RequestMapping(value = "/getNoEvaluateList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrder>> getNoEvaluate(Long userId,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = portalOrderService.getNoEvaluateList(userId,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
    @ApiOperation("手动删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteOrder(Long OrderId){
        portalOrderService.deleteOrder(OrderId);
        return CommonResult.success(null);
    }
    @ApiOperation("确认收货")
    @RequestMapping(value = "/Received", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult Received(Long OrderId){
        portalOrderService.Received(OrderId);
        return CommonResult.success(null);
    }

    @ApiOperation("确认收货")
    @RequestMapping(value = "/cancelOneOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOneOrder(Long OrderId){
        portalOrderService.cancelOneOrder(OrderId);
        return CommonResult.success(null);
    }


    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId) {
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }


}
