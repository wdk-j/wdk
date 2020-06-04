package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.service.TmsSellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Service
public class TmsSellerServiceImpl implements TmsSellerService {

    private Logger log = LoggerFactory.getLogger(TmsSellerServiceImpl.class);

    @Autowired
    private TmsSellerMapper tmsSellerMapper;


}