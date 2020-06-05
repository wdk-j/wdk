package com.commerce.mall.service;

import com.commerce.mall.dto.TmsFoodCommentDetail;
import com.github.pagehelper.PageInfo;

/**
 * @author jiangyong
 * @date 2020.06.05
 */
public interface TmsFoodCommentsService {

    /**
     * 分页查询
     * 关键查询
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param keyword  keyword
     * @return list
     */
    PageInfo<TmsFoodCommentDetail> pagedList(int pageNum, int pageSize, String keyword);

    /**
     * 获取某条评论
     *
     * @param commId comment id
     * @return comment
     */
    TmsFoodCommentDetail get(Integer commId);

    /**
     * 回复评论
     *
     * @param commId comment id
     * @param reply  replies
     * @return code
     */
    int reply(Integer commId, String reply);
}