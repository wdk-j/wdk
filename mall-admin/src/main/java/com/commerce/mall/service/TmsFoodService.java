package com.commerce.mall.service;

import com.commerce.mall.dto.TmsFoodInHome;
import com.commerce.mall.model.TmsFood;

import java.util.List;

/**
 * @author jy
 * @date 2020/6/3
 */
public interface TmsFoodService {

    /**
     * 添加食品
     *
     * @param tmsFood tms food
     */
    void add(TmsFood tmsFood);
}