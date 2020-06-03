package com.commerce.mall.service;

import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsFoodCommentsPicsService {

    /**
     * 获取某评论的配图列表
     *
     * @param commId comment id
     * @return pics
     */
    List<TmsFoodCommentsPics> getList(Integer commId);

    /**
     * 添加一张评论图
     *
     * @param tmsFoodCommentsPic tmsFoodCommentsPic
     */
    void add(TmsFoodCommentsPics tmsFoodCommentsPic);
}