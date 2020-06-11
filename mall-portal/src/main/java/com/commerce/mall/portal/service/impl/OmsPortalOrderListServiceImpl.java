package com.commerce.mall.portal.service.impl;

import com.commerce.mall.model.OmsOrder;
import com.commerce.mall.portal.dao.PortalOrderListDao;
import com.commerce.mall.portal.service.OmsPortalOrderListService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OmsPortalOrderListServiceImpl implements OmsPortalOrderListService {
    @Autowired
    PortalOrderListDao portalOrderListDao;
    @Override
    public List<OmsOrder> getList(Long userId, Integer status, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return portalOrderListDao.getList(userId, status);
    }

    @Override
    public List<OmsOrder> getAllList(Long userId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return portalOrderListDao.getAllList(userId);
    }
}
