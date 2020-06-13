package com.commerce.mall.dao;

import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Deprecated
public interface TmsFoodAttributeDao {

    /**
     * 查找含有关键字的食品
     * id升序
     *
     * @param keyword keyword
     * @return list
     */
    List<TmsFoodWithMainPic> selectByKeyword(String keyword);

    /**
     * 逐渐查找
     *
     * @param foodId foodId
     * @return food
     */
    TmsFoodWithMainPic selectByPrimaryKey(Integer foodId);

    /**
     * 修改isDelete字段
     *
     * @param isDelete is_delete
     * @return affect
     */
    int updateIsDelete(@Param("isDelete") String isDelete, @Param("foodId") Integer foodId);
}
