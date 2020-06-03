package com.commerce.mall.service.impl;

import com.commerce.mall.dao.TmsFoodInHomeDao;
import com.commerce.mall.dto.TmsFoodInHome;
import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.service.TmsSellerService;
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
public class TmsSellerServiceImpl implements TmsSellerService {

    private Logger log = LoggerFactory.getLogger(TmsSellerServiceImpl.class);

    @Autowired
    private TmsSellerMapper tmsSellerMapper;

    @Autowired
    private TmsFoodInHomeDao tmsFoodInHomeDao;

    /**
     * 某卖家首页食品列表
     *
     * @param sellerId seller id
     * @return list
     */
    @Override
    public List<TmsFoodInHome> getHomeFoodList(Integer sellerId) {
        return tmsFoodInHomeDao.selectFoods(sellerId);
    }

}