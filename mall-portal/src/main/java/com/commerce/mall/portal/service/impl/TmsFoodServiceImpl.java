package com.commerce.mall.portal.service.impl;


import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.custom.dao.TmsFoodCommentAboutDao;
import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.portal.dao.TmsFoodDetailDao;
import com.commerce.mall.portal.domain.TmsFoodDetail;
import com.commerce.mall.portal.domain.TmsFoodWithMainPic;
import com.commerce.mall.portal.service.TmsFoodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Service
public class TmsFoodServiceImpl implements TmsFoodService {

    private final Logger log = LoggerFactory.getLogger(TmsFoodServiceImpl.class);

    @Autowired
    private TmsFoodMapper tmsFoodMapper;

    @Autowired
    private TmsFoodDetailDao tmsFoodDetailDao;

    @Autowired
    private TmsFoodCommentAboutDao tmsFoodCommentAboutDao;

    @Autowired
    private TmsFoodAboutDao tmsFoodAboutDao;

    /**
     * 获取一个商品的详情
     *
     * @param foodId food id
     * @return food in detail
     */
    @Override
    public TmsFoodDetail getFoodDetail(Integer foodId) {
        return tmsFoodDetailDao.selectInDetailByPrimaryKey(foodId);
    }

    /**
     * 分页查首页食品
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param sellerId seller id
     * @return page
     */
    @Override
    public PageInfo<TmsFoodWithMainPic> pagedHomeFoods(int pageNum, int pageSize, Integer sellerId) {
        PageHelper.startPage(pageNum, pageSize);
        List<TmsFoodWithMainPic> foods = tmsFoodDetailDao.selectByKeyword(sellerId, null);
        return new PageInfo<>(foods);
    }
}