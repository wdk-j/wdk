package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.service.TmsFoodService;
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
     * @return code
     */
    @Override
    public int add(TmsFood tmsFood) {
        return tmsFoodMapper.insertSelective(tmsFood);
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
        PageHelper.startPage(pageNum, pageSize);
        // 如果为''算为null
        if (StrUtil.isEmpty(keyword)) {
            keyword = null;
        }
        List<TmsFoodWithMainPic> foods = tmsFoodAboutDao.selectByKeyword(sellerId,keyword);
        return new PageInfo<>(foods);
    }

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    @Override
    public TmsFoodWithMainPic get(Integer foodId) {
        return tmsFoodAboutDao.selectByPrimaryKey(foodId);
    }

    /**
     * 更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodId food id
     * @return code
     */
    @Override
    public int updateAttrIsDelete(String isDelete, Integer foodId) {
        return tmsFoodAboutDao.updateIsDelete(isDelete,foodId);
    }

    /**
     * 更新食品
     *
     * @param tmsFood food
     * @return code status
     */
    @Override
    public int update(TmsFood tmsFood){
        return tmsFoodMapper.updateByPrimaryKey(tmsFood);
    }
}