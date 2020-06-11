package com.commerce.mall.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.mapper.TmsFoodCommentsPicsMapper;
import com.commerce.mall.model.TmsFoodCommentsPics;
import com.commerce.mall.model.TmsFoodCommentsPicsExample;
import com.commerce.mall.portal.dao.TmsFoodCommentDetailDao;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

    @Autowired
    private TmsFoodCommentsPicsMapper tmsFoodCommentsPicsMapper;

    /**
     * 获取某食品的所有评论，评论时间降序
     *
     * @param foodId food id
     * @return comment list
     */
    @Override
    public List<TmsFoodCommentDetail> listFoodCommentsInDetail(Integer foodId) {
        return tmsFoodCommentDetailDao.selectCommentsDetailed(foodId, null);
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
    public PageInfo<TmsFoodCommentDetail> pagedFoodCommentsInDetail(int pageNum, int pageSize, Integer foodId, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<TmsFoodCommentDetail> foodCommentDetails = null;
        foodCommentDetails = tmsFoodCommentDetailDao.selectCommentsDetailed(foodId, keyword);

        List<TmsFoodCommentsPics> pics;
        TmsFoodCommentsPicsExample example;
        if ("2".equals(keyword)) {
            Iterator<TmsFoodCommentDetail> iterator = foodCommentDetails.iterator();
            TmsFoodCommentDetail next;
            while (iterator.hasNext()) {
                next = iterator.next();
                example = new TmsFoodCommentsPicsExample();
                example.createCriteria().andCommIdEqualTo(next.getCommId());
                pics = tmsFoodCommentsPicsMapper.selectByExample(example);
                if (CollUtil.isEmpty(pics)) {
                    iterator.remove();
                }
            }
        }
        return new PageInfo<>(foodCommentDetails);
    }

}