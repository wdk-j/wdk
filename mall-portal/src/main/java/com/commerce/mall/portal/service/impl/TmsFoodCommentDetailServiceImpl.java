package com.commerce.mall.portal.service.impl;

import com.commerce.mall.custom.dao.TmsFoodCommentAboutDao;
import com.commerce.mall.portal.dao.TmsFoodCommentDetailDao;
import com.commerce.mall.portal.domain.TmsFoodCommentDetail;
import com.commerce.mall.portal.service.TmsFoodCommentDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    private TmsFoodCommentAboutDao tmsFoodCommentAboutDao;


    /**
     * 获取某食品的所有评论，评论时间降序
     *
     * @param foodId food id
     * @return comment list
     */
    @Override
    public List<TmsFoodCommentDetail> listFoodCommentsInDetail(Integer foodId) {
        List<TmsFoodCommentDetail> foodCommentDetails = tmsFoodCommentDetailDao.selectCommentsDetailed(foodId);
        foodCommentDetails.forEach(fc -> {
            fc.setPositiveRate(calculatePositiveRate(fc.getFoodId()));
        });
        return foodCommentDetails;
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
        List<TmsFoodCommentDetail> foodCommentDetails = tmsFoodCommentDetailDao.selectCommentsDetailed(foodId);
        foodCommentDetails.forEach(fc -> {
            fc.setPositiveRate(calculatePositiveRate(fc.getFoodId()));
        });
        return new PageInfo<>(foodCommentDetails);
    }

    private Double calculatePositiveRate(Integer foodId) {
        int positive = tmsFoodCommentAboutDao.countNiceEqualTo("1", foodId);
        int navigate = tmsFoodCommentAboutDao.countNiceEqualTo("0", foodId);
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(positive * 100 / (positive + navigate));
        return Double.parseDouble(format);
    }
}