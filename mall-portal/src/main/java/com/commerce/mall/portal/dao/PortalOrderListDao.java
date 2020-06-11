package com.commerce.mall.portal.dao;

import com.commerce.mall.model.OmsOrder;

import java.util.List;

public interface PortalOrderListDao {
    List<OmsOrder> getList(Long userId, int status);

    List<OmsOrder> getAllList(Long userId);
}
