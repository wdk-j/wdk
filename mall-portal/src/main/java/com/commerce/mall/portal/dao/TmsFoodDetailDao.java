package com.commerce.mall.portal.dao;

import com.commerce.mall.portal.domain.TmsFoodWithMainPic;
import com.commerce.mall.portal.domain.TmsFoodDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsFoodDetailDao {

    /**
     * 查找含有关键字的食品
     * mark降序
     *
     * @param keyword keyword
     * @return list
     */
    List<TmsFoodWithMainPic> selectByKeyword(@Param("sellerId") Integer sellerId, @Param("keyword") String keyword);

    /**
     * 逐渐查找
     *
     * @param foodId foodId
     * @return food
     */
    TmsFoodDetail selectInDetailByPrimaryKey(Integer foodId);
}
