package com.commerce.mall.portal.service.impl;

import com.commerce.mall.portal.dao.TmsFoodCommentDetailDao;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Service
public class TmsFoodCommentDetailServiceImpl implements TmsFoodCommentDetailService {

    private Logger log = LoggerFactory.getLogger(TmsFoodCommentDetailServiceImpl.class);

    @Autowired
    private TmsFoodCommentDetailDao tmsFoodCommentDetailDao;


    /**
     * 获取某食品的所有评论，评论时间降序
     *
     * @param foodId food id
     * @return comment list
     */
    @Override
    public List<TmsFoodCommentDetail> listFoodCommentsInDetail(Integer foodId) {
        return tmsFoodCommentDetailDao.selectCommentsDetailed(foodId);
    }

    /**
     * 分页查询
     * 获取某食品的所有评论，评论时间降序
     *
     * @param pageNum  页号
     * @param pageSize 页大小
     * @param foodId   food id
     * @return a page of comment
     */
    @Override
    public PageInfo<TmsFoodCommentDetail> pagedFoodCommentsInDetail(int pageNum, int pageSize, Integer foodId) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(tmsFoodCommentDetailDao.selectCommentsDetailed(foodId));
    }
}