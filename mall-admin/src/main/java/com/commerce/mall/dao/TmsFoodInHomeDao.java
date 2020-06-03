package com.commerce.mall.dao;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsFoodInHomeDao {

    /**
     * 查某卖家的首页商品列表
     * @param sellerId seller id
     */
    void selectFoods(Integer sellerId);
}
