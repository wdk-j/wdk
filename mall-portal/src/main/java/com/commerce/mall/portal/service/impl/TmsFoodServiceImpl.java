package com.commerce.mall.portal.service.impl;

import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.portal.service.TmsFoodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private TmsFoodAboutDao tmsFoodAboutDao;

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
    public TmsFoodWithPics getFoodDetail(Integer foodId) {
        return tmsFoodAboutDao.selectFoodWithPicsByPrimaryKey(foodId);
    }

    /**
     * 某卖家首页食品列表
     *
     * @param sellerId seller id
     * @return list
     */
    @Override
    public List<TmsFoodWithMainPic> listHomeFoods(Integer sellerId) {
        return tmsFoodAboutDao.selectByKeyword(sellerId, null);
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
        List<TmsFoodWithMainPic> foods = tmsFoodAboutDao.selectByKeyword(sellerId, null);
        return new PageInfo<>(foods);
    }
}