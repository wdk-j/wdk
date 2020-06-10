package com.commerce.mall.portal.service.impl;


import com.commerce.mall.custom.dao.TmsFoodAboutDao;
import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.portal.service.TmsSellerService;
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
@Deprecated
public class TmsSellerServiceImpl implements TmsSellerService {

    private Logger log = LoggerFactory.getLogger(TmsSellerServiceImpl.class);

    @Autowired
    private TmsSellerMapper tmsSellerMapper;

    @Autowired
    private TmsFoodAboutDao tmsFoodAboutDao;

    /**
     * 某卖家首页食品列表
     *
     * @param sellerId seller id
     * @return list
     */
    @Override
    public List<TmsFoodWithMainPic> listHomeFoods(Integer sellerId) {
        return tmsFoodAboutDao.selectByKeyword(sellerId, null);
    }

}