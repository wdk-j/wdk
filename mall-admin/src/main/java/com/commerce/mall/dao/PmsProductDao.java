package com.commerce.mall.dao;

import com.commerce.mall.dto.PmsProductResult;
import com.commerce.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * 自定义商品管理Dao
 * Created by commerce on 2018/4/26.
 */
public interface PmsProductDao {

    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
