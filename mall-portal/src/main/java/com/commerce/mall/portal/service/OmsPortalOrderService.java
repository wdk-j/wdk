package com.commerce.mall.portal.service;

import com.commerce.mall.model.OmsOrder;
import com.commerce.mall.portal.domain.ConfirmOrderResult;
import com.commerce.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理Service
 * Created by commerce on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认单信息
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    Integer paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /*
    * 删除订单
     */
    void deleteOrder(Long orderId);
    /*
     * 查询订单操做
     */
    List<OmsOrder> getNoPayList(Long userId, Integer pageSize, Integer pageNum);

    List<OmsOrder> getAllList(Long userId, Integer pageSize, Integer pageNum);

    List<OmsOrder> getNoReceivedList(Long userId, Integer pageSize, Integer pageNum);

    List<OmsOrder> getNoEvaluateList(Long userId, Integer pageSize, Integer pageNum);
}
