package com.commerce.mall.service.impl;

import com.commerce.mall.dao.TmsFoodPicsDao;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.service.TmsFoodPicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.07
 */
@Service
public class TmsFoodPicsServiceImpl implements TmsFoodPicsService {

    @Autowired
    private TmsFoodPicsDao tmsFoodPicsDao;

    /**
     * 某食物批量添加图片
     *
     * @param foodPics foodPics
     * @return effects
     */
    @Override
    public int addFoodPicsInBatch(List<TmsFoodPics> foodPics) {
        return tmsFoodPicsDao.insertSelectiveInBatch(foodPics);
    }
}
