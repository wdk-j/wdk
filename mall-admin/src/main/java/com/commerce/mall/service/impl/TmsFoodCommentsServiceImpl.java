package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.TmsFoodCommentsMapper;
import com.commerce.mall.service.TmsFoodCommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangyong
 * @date 2020.06.05
 */
@Service
public class TmsFoodCommentsServiceImpl implements TmsFoodCommentsService {

    private Logger log = LoggerFactory.getLogger(TmsFoodCommentsServiceImpl.class);

    @Autowired
    private TmsFoodCommentsMapper tmsFoodCommentsMapper;


}