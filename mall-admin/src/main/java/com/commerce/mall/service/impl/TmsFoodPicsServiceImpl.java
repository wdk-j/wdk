package com.commerce.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.commerce.mall.mapper.TmsFoodPicsMapper;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.model.TmsFoodPicsExample;
import com.commerce.mall.service.TmsFoodPicsService;
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
public class TmsFoodPicsServiceImpl implements TmsFoodPicsService {

    private Logger log = LoggerFactory.getLogger(TmsFoodPicsServiceImpl.class);

    @Autowired
    private TmsFoodPicsMapper tmsFoodPicsMapper;

    /**
     * @param foodId foodId
     * @return list
     */
    @Override
    public List<TmsFoodPics> getList(Integer foodId) {
        TmsFoodPicsExample example = new TmsFoodPicsExample();
        example.createCriteria().andFoodIdEqualTo(foodId);
        return tmsFoodPicsMapper.selectByExample(example);
    }

    /**
     * @param foodId foodId
     * @return one
     */
    @Override
    public TmsFoodPics getMainPic(Integer foodId) {
        TmsFoodPicsExample example = new TmsFoodPicsExample();
        example.createCriteria().andFoodIdEqualTo(foodId).andIsMainEqualTo("1");
        List<TmsFoodPics> tmsFoodPics = tmsFoodPicsMapper.selectByExample(example);
        if (!CollUtil.isEmpty(tmsFoodPics)) {
            return tmsFoodPics.get(0);
        }
        // 如果没有主图，拿第一个
        example = new TmsFoodPicsExample();
        example.createCriteria().andFoodIdEqualTo(foodId);
        tmsFoodPics = tmsFoodPicsMapper.selectByExample(example);
        if (!CollUtil.isEmpty(tmsFoodPics)) {
            return tmsFoodPics.get(0);
        }
        return null;
    }

    /**
     * @param tmsFoodPics tmsFoodPics
     */
    @Override
    public void add(TmsFoodPics tmsFoodPics) {
        tmsFoodPicsMapper.insert(tmsFoodPics);
    }
}