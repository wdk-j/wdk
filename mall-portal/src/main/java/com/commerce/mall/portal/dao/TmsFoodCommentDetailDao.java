package com.commerce.mall.portal.dao;


import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Deprecated
public interface TmsFoodCommentDetailDao {

    /**
     * 查所有详细的评论
     *
     * @param foodId food id
     * @return comments
     */
    List<TmsFoodCommentDetail> selectCommentsDetailed(@Param("foodId") Integer foodId, @Param("keyword") String keyword);
}