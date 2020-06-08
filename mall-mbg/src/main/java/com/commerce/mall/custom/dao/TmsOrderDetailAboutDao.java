package com.commerce.mall.custom.dao;

/**
 * @author jiangyong
 * @date 2020.06.08
 */
public interface TmsOrderDetailAboutDao {

    /**
     * 计算某食物的销量
     * @param foodId food id
     * @return sales
     */
    int countSales(String foodId);
}
