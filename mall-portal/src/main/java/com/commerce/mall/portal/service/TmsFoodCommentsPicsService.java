package com.commerce.mall.portal.service;

import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsFoodCommentsPicsService {

    /**
     * 添加一张评论图
     *
     * @param tmsFoodCommentsPic tmsFoodCommentsPic
     */
    void add(TmsFoodCommentsPics tmsFoodCommentsPic);
}