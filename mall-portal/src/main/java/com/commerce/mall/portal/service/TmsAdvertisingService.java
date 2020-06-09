package com.commerce.mall.portal.service;

import com.commerce.mall.model.TmsAdvertising;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.09
 */
public interface TmsAdvertisingService {

    /**
     * 返回广告列表
     *
     * @return list
     */
    List<TmsAdvertising> list();
}
