package com.commerce.mall.dao;

import com.commerce.mall.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品满减Dao
 * Created by commerce on 2018/4/26.
 */
public interface PmsProductFullReductionDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
