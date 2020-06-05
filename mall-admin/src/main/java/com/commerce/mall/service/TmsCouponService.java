package com.commerce.mall.service;

import com.commerce.mall.model.TmsCoupon;
import com.github.pagehelper.PageInfo;


public interface TmsCouponService {

    PageInfo<TmsCoupon> pagedList(int pageSize, int pageNum );

    int addTmsCoupon(TmsCoupon tmsCoupon);

    int deleteTmsCoupon(Integer id);

    int updateTmsCoupon(TmsCoupon tmsCoupon);

    TmsCoupon getTmsCoupon(Integer id);

}
