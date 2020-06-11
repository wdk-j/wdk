package com.commerce.mall.portal.service.impl;

import com.commerce.mall.mapper.TmsAdvertisingMapper;
import com.commerce.mall.model.TmsAdvertising;
import com.commerce.mall.model.TmsAdvertisingExample;
import com.commerce.mall.portal.service.TmsAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.09
 */
@Service
public class TmsAdvertisingServiceImpl implements TmsAdvertisingService {

    @Autowired
    private TmsAdvertisingMapper tmsAdvertisingMapper;

    /**
     * 返回广告列表
     *
     * @return list
     */
    @Override
    public List<TmsAdvertising> list() {
        String orderBy = "sort desc";
        TmsAdvertisingExample example = new TmsAdvertisingExample();
        example.createCriteria().andIsDeleteEqualTo("0");
        example.setOrderByClause(orderBy);
        return tmsAdvertisingMapper.selectByExample(example);
    }
}
