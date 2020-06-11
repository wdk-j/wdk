package com.commerce.mall.portal.service;

import com.commerce.mall.model.OmsOrder;

import java.util.List;

public interface OmsPortalOrderListService {
    List<OmsOrder> getList(Long userId, Integer status, Integer pageSize, Integer pageNum);

    List<OmsOrder> getAllList(Long userId, Integer pageSize, Integer pageNum);
}
