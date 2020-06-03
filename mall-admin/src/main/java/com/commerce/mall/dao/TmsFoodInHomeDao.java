package com.commerce.mall.dao;

import com.commerce.mall.dto.TmsFoodInHome;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsFoodInHomeDao {

    /**
     * 查某卖家的首页商品列表
     *
     * @param sellerId seller id
     */
    List<TmsFoodInHome> selectFoods(Integer sellerId);
}
