package com.commerce.mall.dao;

import com.commerce.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优惠券和商品分类关系管理Dao
 * Created by commerce on 2018/8/28.
 */
public interface SmsCouponProductCategoryRelationDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
