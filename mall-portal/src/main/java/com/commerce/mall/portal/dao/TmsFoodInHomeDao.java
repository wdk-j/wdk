package com.commerce.mall.portal.dao;


import com.commerce.mall.portal.domain.TmsFoodInHome;
import org.apache.ibatis.annotations.Param;

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
     * @return list
     */
    List<TmsFoodInHome> listFoods(@Param("sellerId") Integer sellerId);
}
