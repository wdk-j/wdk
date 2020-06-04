package com.commerce.mall.portal.dao;

import com.commerce.mall.portal.domain.TmsFoodDetail;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsFoodDetailDao {

    TmsFoodDetail selectFoodInDetail(Integer foodId);
}
