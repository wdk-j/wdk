package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.model.TmsSellerExample;
import com.commerce.mall.service.TmsSellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    /**
     * 根据seller_id查找商家
     *
     * @param sellerId
     * @return
     */
    @Override
    public TmsSeller getTmsSellerById(Integer sellerId) {
        return tmsSellerMapper.selectByPrimaryKey(sellerId);
    }

    @Override
    public void addTmsSeller(TmsSeller tmsSeller) {
        tmsSeller.setClosed("0");
        tmsSeller.setIsDelete("0");
        tmsSellerMapper.insertSelective(tmsSeller);
    }

    /**
     * 更改商家信息
     *
     * @param tmsSeller
     * @return
     */
    @Override
    public int updateTmsSeller(TmsSeller tmsSeller) {
        TmsSellerExample tmsSellerExample = new TmsSellerExample();
        tmsSellerExample.createCriteria().andSellerIdEqualTo(tmsSeller.getSellerId());
        return tmsSellerMapper.updateByExampleSelective(tmsSeller,tmsSellerExample);
    }

    /**
     * 根据seller_id删除商家
     *
     * @param sellerId
     */
    @Override
    public void deleteTmsSellerById(Integer sellerId) {
        tmsSellerMapper.deleteByPrimaryKey(sellerId);
    }
}