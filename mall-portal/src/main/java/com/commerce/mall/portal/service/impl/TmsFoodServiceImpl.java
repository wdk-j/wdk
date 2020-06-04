package com.commerce.mall.portal.service.impl;

import com.commerce.mall.mapper.TmsFoodMapper;
import com.commerce.mall.model.TmsFood;
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

    /**
     * 添加食品
     *
     * @param tmsFood tms food
     */
    @Override
    public void add(TmsFood tmsFood) {
        tmsFoodMapper.insert(tmsFood);
    }

}