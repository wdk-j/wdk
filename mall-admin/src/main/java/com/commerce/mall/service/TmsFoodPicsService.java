package com.commerce.mall.service;

import com.commerce.mall.model.TmsFoodPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.07
 */
public interface TmsFoodPicsService {

    /**
     * 某食物批量添加图片
     *
     * @param foodPics foodPics
     * @return effects
     */
    int addFoodPicsInBatch(List<TmsFoodPics> foodPics);
}
