package com.commerce.mall.service;

import com.commerce.mall.model.TmsFoodPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public interface TmsFoodPicsService {

    /**
     *
     * @param foodId foodId
     * @return list
     */
    List<TmsFoodPics> getList(Integer foodId);

    /**
     *
     * @param foodId foodId
     * @return one
     */
    TmsFoodPics getMainPic(Integer foodId);

    /**
     *
     * @param tmsFoodPics tmsFoodPics
     */
    void add(TmsFoodPics tmsFoodPics);
}