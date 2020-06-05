package com.commerce.mall.dao;



import com.commerce.mall.dto.TmsFoodCommentDetail;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsFoodCommentDetailDao {

    /**
     * 查所有详细的评论
     *
     * @param foodId food id
     * @return comments
     */
    List<TmsFoodCommentDetail> selectCommentsDetailed(Integer foodId);
}