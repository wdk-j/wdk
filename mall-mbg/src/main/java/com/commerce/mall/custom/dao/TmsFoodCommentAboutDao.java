package com.commerce.mall.custom.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author jiangyong
 * @date 2020.06.08
 */
public interface TmsFoodCommentAboutDao {

    /**
     * 查nice等于keyword的记录数
     *
     * @param keyword keyword
     * @param foodId food id
     * @return nice rate
     */
    int countNiceEqualTo(@Param("keyword") String keyword, @Param("foodId") Integer foodId);
}
