package com.commerce.mall.portal.service;

import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsFoodCommentDetailService {

    /**
     * 获取某食品的所有评论，评论时间降序
     *
     * @param foodId food id
     * @return comment list
     */
    List<TmsFoodCommentDetail> listFoodCommentsInDetail(Integer foodId);

    /**
     * 分页查询
     * 获取某食品的所有评论，评论时间降序
     *
     * @param pageNum  页号
     * @param pageSize 页大小
     * @param foodId   food id
     * @return a page of comment
     */
    PageInfo<TmsFoodCommentDetail> pagedFoodCommentsInDetail(int pageNum, int pageSize, Integer foodId);
}