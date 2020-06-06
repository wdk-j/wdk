package com.commerce.mall.dao;


import com.commerce.mall.dto.TmsFoodCommentDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsFoodCommentDetailDao {

    /**
     * 查所有详细的评论
     *
     * @param foodId  food id
     * @param keyword keyword
     * @param sellerId
     * @return comments
     */
    List<TmsFoodCommentDetail> selectCommentsDetailed(@Param("foodId") Integer foodId,
                                                      @Param("keyword") String keyword,@Param("sellerId")Integer sellerId);

    /**
     * 主键查找评论
     *
     * @param commId comment id
     * @return detail comment
     */
    TmsFoodCommentDetail selectByPrimaryKey(Integer commId);

    /**
     * 卖家回复评论
     *
     * @param commId comment id
     * @param reply  reply
     * @return code
     */
    int updateReplyByPrimaryKey(@Param("commId") Integer commId, @Param("reply") String reply);
}