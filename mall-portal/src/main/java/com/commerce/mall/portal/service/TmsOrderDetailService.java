package com.commerce.mall.portal.service;

/**
 * @author jiangyong
 * @date 2020.06.08
 */
public interface TmsOrderDetailService {

    /**
     * 获取某食品的销量
     *
     * @param foodId food id
     * @return sales
     */
    int getSales(Integer foodId);
}
