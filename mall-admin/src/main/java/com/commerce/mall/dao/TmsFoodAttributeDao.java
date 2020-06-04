package com.commerce.mall.dao;

import com.commerce.mall.dto.TmsFoodWithMainPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
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
     * 修改isDelete字段
     *
     * @param isDelete is_delete
     * @return affect
     */
    int updateIsDelete(@Param("isDelete") String isDelete, @Param("foodId") Integer foodId);
}
