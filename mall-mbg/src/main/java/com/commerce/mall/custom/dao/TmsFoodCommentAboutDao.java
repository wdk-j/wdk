package com.commerce.mall.custom.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

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
    BigDecimal selectPosiEval(@Param("keyword") String keyword, @Param("foodId") Integer foodId);
}
