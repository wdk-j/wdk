package com.commerce.mall.portal.dao;

import com.commerce.mall.portal.domain.CartProduct;
import com.commerce.mall.portal.domain.PromotionProduct;
import com.commerce.mall.portal.domain.CartProduct;
import com.commerce.mall.portal.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 * Created by commerce on 2018/8/2.
 */
public interface PortalProductDao {

    CartProduct getCartProduct(@Param("id") Long id);

    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
}
