package com.commerce.mall.portal.service;

import com.commerce.mall.portal.domain.TmsFoodDetail;
import com.commerce.mall.portal.domain.TmsFoodWithMainPic;
import com.github.pagehelper.PageInfo;

/**
 * food 以及 food detail
 *
 * @author jy
 * @date 2020/6/3
 */
public interface TmsFoodService {

    /**
     * 获取一个商品的详情
     *
     * @param foodId food id
     * @return food in detail
     */
    TmsFoodDetail getFoodDetail(Integer foodId);

    /**
     * 分页查首页食品
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param sellerId seller id
     * @return page
     */
    PageInfo<TmsFoodWithMainPic> pagedHomeFoods(int pageNum, int pageSize, Integer sellerId);
}