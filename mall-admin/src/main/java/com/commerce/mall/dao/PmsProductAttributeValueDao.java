package com.commerce.mall.dao;

import com.commerce.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 * Created by commerce on 2018/4/26.
 */
public interface PmsProductAttributeValueDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
