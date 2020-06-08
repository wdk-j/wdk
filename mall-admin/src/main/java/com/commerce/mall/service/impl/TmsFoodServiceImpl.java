package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.common.utils.FileUtil;
import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.dao.TmsFoodPicsDao;
import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.mapper.TmsFoodPicsMapper;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.service.TmsFoodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private TmsFoodAboutDao tmsFoodAboutDao;

    @Autowired
    private TmsFoodPicsDao tmsFoodPicsDao;

    /**
     * 添加食品
     *
     * @param pics   pics
     * @param tmsFood tms food
     * @return code
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int add(List<TmsFoodPics> pics, TmsFood tmsFood) {
        int r = tmsFoodMapper.insertSelective(tmsFood);
        Integer foodId = tmsFood.getFoodId();
        pics.get(0).setIsMain("1");
        pics.forEach(pic->{
            pic.setFoodId(foodId);
        });
        tmsFoodPicsDao.insertSelectiveInBatch(pics);
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
        if (StrUtil.isEmpty(keyword)) {
            keyword = null;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TmsFoodWithMainPic> foods = tmsFoodAboutDao.selectByKeyword(sellerId, keyword);
        return new PageInfo<>(foods);
    }

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    @Override
    public TmsFoodWithPics get(Integer foodId) {
        return tmsFoodAboutDao.selectFoodWithPicsByPrimaryKey(foodId);
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
        return tmsFoodAboutDao.updateIsDelete(isDelete, foodId);
    }

    /**
     * 批量更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodIds   food ids
     * @return code
     */
    @Override
    public int updateAttrIsDeleteInBatch(String isDelete, List<Integer> foodIds) {

        return tmsFoodAboutDao.updateIsDeleteInBatch(isDelete, foodIds);
    }

    /**
     * 更新食品
     *
     * @param tmsFoodWithPics food
     * @return code status
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TmsFoodWithPics tmsFoodWithPics) {
        TmsFood tmsFood = new TmsFood();
        BeanUtils.copyProperties(tmsFoodWithPics, tmsFood);
        List<TmsFoodPics> pics = tmsFoodWithPics.getPics();
        boolean hasMainPic = false;

        for (TmsFoodPics pic : pics) {
            if ("1".equals(pic.getIsMain())) {
                hasMainPic = true;
                break;
            }
        }

        for (TmsFoodPics pic : pics) {
            if (pic.getPicId() == null) {
                if (!hasMainPic) {
                    pic.setIsMain("1");
                }
                pic.setFoodId(tmsFoodWithPics.getFoodId());
                tmsFoodPicsMapper.insertSelective(pic);
            }
            else if (StrUtil.isEmpty(pic.getPicUrl())) {
                tmsFoodPicsMapper.deleteByPrimaryKey(pic.getPicId());
            }
        }
        return tmsFoodMapper.updateByPrimaryKey(tmsFood);
    }
}