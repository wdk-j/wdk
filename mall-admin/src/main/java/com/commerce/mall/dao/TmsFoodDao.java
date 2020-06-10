package com.commerce.mall.dao;

import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.dto.TmsFoodWithPicsResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.10
 */
public interface TmsFoodDao {
    /**
     * 查找含有关键字的食品
     * sales降序
     * idDelete为0
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
    TmsFoodWithPicsResult selectFoodWithPicsByPrimaryKey(Integer foodId);

    /**
     * 修改isDelete字段
     *
     * @param isDelete is_delete
     * @param foodId   food id
     * @return affect
     */
    int updateIsDelete(@Param("isDelete") String isDelete, @Param("foodId") Integer foodId);

    /**
     * 批量修改isDelete字段
     *
     * @param isDelete is_delete
     * @param foodIds  food id
     * @return affect
     */
    int updateIsDeleteInBatch(@Param("isDelete") String isDelete, @Param("foodIds") List<Integer> foodIds);

    /**
     * 修改isOff字段
     *
     * @param isOff is_delete
     * @param foodId   food id
     * @return affect
     */
    int updateIsOff(@Param("isOff") String isOff, @Param("foodId") Integer foodId);

    /**
     * 批量修改isOff字段
     *
     * @param isOff is_delete
     * @param foodIds  food id
     * @return affect
     */
    int updateIsOffInBatch(@Param("isOff") String isOff, @Param("foodIds") List<Integer> foodIds);
}
