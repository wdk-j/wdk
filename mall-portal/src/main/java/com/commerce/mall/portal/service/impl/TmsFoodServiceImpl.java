package com.commerce.mall.portal.service.impl;

import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.portal.dao.TmsFoodCommentDetailDao;
import com.commerce.mall.portal.dao.TmsFoodDetailDao;
import com.commerce.mall.portal.domain.TmsFoodDetail;
import com.commerce.mall.portal.service.TmsFoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Service
public class TmsFoodServiceImpl implements TmsFoodService {

    private Logger log = LoggerFactory.getLogger(TmsFoodServiceImpl.class);

    @Autowired
    private TmsFoodMapper tmsFoodMapper;

    @Autowired
    private TmsFoodDetailDao tmsFoodDetailDao;

    /**
     * 添加食品
     *
     * @param tmsFood tms food
     */
    @Override
    public void add(TmsFood tmsFood) {
        tmsFoodMapper.insert(tmsFood);
    }

    /**
     * 获取一个商品的详情
     *
     * @param foodId food id
     * @return food in detail
     */
    @Override
    public TmsFoodDetail getFoodDetail(Integer foodId) {
        return tmsFoodDetailDao.selectFoodInDetail(foodId);
    }
}