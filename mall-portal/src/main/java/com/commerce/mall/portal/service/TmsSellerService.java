package com.commerce.mall.portal.service;


import com.commerce.mall.portal.domain.TmsFoodInHome;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsSellerService {

    /**
     * 某卖家首页食品列表
     *
     * @param sellerId seller id
     * @return list
     */
    List<TmsFoodInHome> listHomeFoods(Integer sellerId);
}