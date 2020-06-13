package com.commerce.mall.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.commerce.mall.common.utils.FileUtil;
import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.custom.dao.TmsFoodCommentAboutDao;
import com.commerce.mall.dao.TmsFoodDao;
import com.commerce.mall.dao.TmsFoodPicsDao;
import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.dto.TmsFoodWithPicsResult;
import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.mapper.TmsFoodPicsMapper;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.model.TmsFoodPicsExample;
import com.commerce.mall.service.TmsFoodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Transactional
@Service
@Slf4j
public class TmsFoodServiceImpl implements TmsFoodService {

    @Autowired
    private TmsFoodMapper tmsFoodMapper;

    @Autowired
    private TmsFoodPicsMapper tmsFoodPicsMapper;

    @Autowired
    private TmsFoodPicsDao tmsFoodPicsDao;

    @Autowired
    private TmsFoodCommentAboutDao tmsFoodCommentAboutDao;

    @Autowired
    private TmsFoodDao tmsFoodDao;

    @Autowired
    private TmsFoodAboutDao tmsFoodAboutDao;


    /**
     * 添加食品
     *
     * @param tmsFoodWithPicsResult pics
     * @return code
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int add(TmsFoodWithPicsResult tmsFoodWithPicsResult) {

        TmsFood tmsFood = new TmsFood();
        BeanUtils.copyProperties(tmsFoodWithPicsResult, tmsFood);

        // already default
        //tmsFood.setIsDelete("0");
        //tmsFood.setIsOff("0");
        Date date = new Date();
        tmsFood.setCreateDate(date);
        int r = tmsFoodMapper.insertSelective(tmsFood);
        Integer foodId = tmsFood.getFoodId();

        List<TmsFoodPics> pics = tmsFoodWithPicsResult.getPics();
        pics.forEach(p -> {
            p.setFoodId(foodId);
        });
        pics.get(0).setIsMain("1");

        for (TmsFoodPics pic : pics) {
            tmsFoodPicsMapper.insertSelective(pic);
        }

        return r;
    }

    /**
     * 删除商品
     *
     * @param foodId food id
     * @return code
     */
    @Override
    public int delete(Integer foodId) {
        TmsFoodPicsExample example = new TmsFoodPicsExample();
        example.createCriteria().andFoodIdEqualTo(foodId);
        // 删除原文件
        List<TmsFoodPics> pics = tmsFoodPicsMapper.selectByExample(example);
        pics.forEach(p->{
            FileUtil.delete(p.getPicUrl());
        });
        tmsFoodPicsMapper.deleteByExample(example);
        return tmsFoodMapper.deleteByPrimaryKey(foodId);
    }

    /**
     * 分页
     * 获取商品列表
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param sellerId seller id
     * @param keyword  keyword
     * @return a page of food
     */
    @Override
    public PageInfo<TmsFoodWithMainPic> listFoods(int pageNum, int pageSize, Integer sellerId, String keyword) {
        // 如果为''算为null
        if (!StrUtil.isEmpty(keyword)) {
            keyword = '%' + keyword + '%';
        }else{
            keyword = null;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TmsFoodWithMainPic> foods = tmsFoodDao.selectByKeyword(sellerId, keyword);
        //todo 封装评分、销量
//        BigDecimal mark;
//        int sales;
//        for (TmsFoodWithMainPic food : foods) {
//             mark = tmsFoodCommentAboutDao.selectPosiEval("1", food.getFoodId());
//             sales = tmsFoodAboutDao.selectSales(food.getFoodId());
//            food.setMark(mark);
//            food.setSales(sales);
//        }

        return new PageInfo<>(foods);
    }

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    @Override
    public TmsFoodWithPicsResult get(Integer foodId) {
        TmsFoodWithPicsResult food = tmsFoodDao.selectFoodWithPicsByPrimaryKey(foodId);
        BigDecimal mark;
        mark = tmsFoodCommentAboutDao.selectPosiEval("1", foodId);
        food.setMark(mark);
        return food;
    }

    /**
     * 更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodId   food id
     * @return code
     */
    @Override
    public int updateAttrIsDelete(String isDelete, Integer foodId) {
        return tmsFoodDao.updateIsDelete(isDelete, foodId);
    }

    /**
     * 批量更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodIds  food ids
     * @return code
     */
    @Override
    public int updateAttrIsDeleteInBatch(String isDelete, List<Integer> foodIds) {
        return tmsFoodDao.updateIsDeleteInBatch(isDelete, foodIds);
    }

    /**
     * 更新isOff字段
     *
     * @param isOff  is off
     * @param foodId food id
     * @return code
     */
    @Override
    public int updateAttrIsOff(String isOff, Integer foodId) {
        return tmsFoodDao.updateIsOff(isOff, foodId);
    }

    /**
     * 批量更新isOff字段
     *
     * @param isOff   is off
     * @param foodIds food id
     * @return code
     */
    @Override
    public int updateAttrIsOffInBatch(String isOff, List<Integer> foodIds) {
        return tmsFoodDao.updateIsOffInBatch(isOff, foodIds);
    }

    /**
     * 更新食品
     *
     * @param tmsFoodWithPicsResult food
     * @return code status
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TmsFoodWithPicsResult tmsFoodWithPicsResult) {
        TmsFood tmsFood = new TmsFood();
        BeanUtils.copyProperties(tmsFoodWithPicsResult, tmsFood);
        List<TmsFoodPics> pics = tmsFoodWithPicsResult.getPics();
        boolean hasMainPic = false;
        log.info(pics.toString());
        Integer foodId = pics.get(0).getFoodId();
        TmsFoodPics mainPic;

        mainPic = tmsFoodPicsDao.selectMainPic(foodId);
        hasMainPic = mainPic != null;

        for (TmsFoodPics pic : pics) {
            if (StrUtil.isEmpty(pic.getPicUrl())) {
                tmsFoodPicsMapper.deleteByPrimaryKey(pic.getPicId());
                mainPic = tmsFoodPicsDao.selectMainPic(foodId);
                hasMainPic = mainPic != null;
            } else if (pic.getPicId() != null) {
                if (!hasMainPic) {
                    pic.setIsMain("1");
                    tmsFoodPicsMapper.updateByPrimaryKey(pic);
                    hasMainPic = true;
                }
            } else {
                if (!hasMainPic) {
                    pic.setIsMain("1");
                    hasMainPic = true;
                }
                pic.setFoodId(foodId);
                tmsFoodPicsMapper.insertSelective(pic);
            }
        }
        return tmsFoodMapper.updateByPrimaryKeySelective(tmsFood);
    }
}