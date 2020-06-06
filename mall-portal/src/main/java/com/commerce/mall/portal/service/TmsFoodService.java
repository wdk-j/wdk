package com.commerce.mall.portal.service;

import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.portal.domain.TmsFoodDetail;

import java.util.List;

/**
 * food 以及 food detail
 *
 * @author jy
 * @date 2020/6/3
 */
public interface TmsFoodService {

    /**
     * 添加食品
     *
     * @param tmsFood tms food
     */
    void add(TmsFood tmsFood);

    /**
     * 获取一个商品的详情
     *
     * @param foodId food id
     * @return food in detail
     */
    TmsFoodWithPics getFoodDetail(Integer foodId);

    /**
     * 某卖家首页食品列表
     *
     * @param sellerId seller id
     * @return list
     */
    List<TmsFoodWithMainPic> listHomeFoods(Integer sellerId);
}