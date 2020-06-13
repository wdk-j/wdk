package com.commerce.mall.custom.dao;

import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.12
 */
public interface TmsFoodCommentPicsDao {

    /**
     * 根据评论id获取评论的所有配图
     *
     * @param commId comment id
     * @return lsit
     */
    List<TmsFoodCommentsPics> selectList(Integer commId);
}
