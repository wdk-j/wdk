package com.commerce.mall.dao;

import com.commerce.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 * Created by commerce on 2018/5/23.
 */
public interface PmsProductCategoryAttributeRelationDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
