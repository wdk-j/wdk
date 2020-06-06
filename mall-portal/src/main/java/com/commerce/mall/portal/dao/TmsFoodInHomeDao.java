package com.commerce.mall.portal.dao;


import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Deprecated
public interface TmsFoodInHomeDao {

    /**
     * 查某卖家的首页商品列表
     *
     * @param sellerId seller id
     * @return list
     */
    List<TmsFoodWithMainPic> listFoods(@Param("sellerId") Integer sellerId);
}
