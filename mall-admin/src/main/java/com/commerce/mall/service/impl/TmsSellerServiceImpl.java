package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.custom.dao.TmsSellerDetailDao;
import com.commerce.mall.custom.dto.TmsSellerDetail;
import com.commerce.mall.dao.TmsSellerDao;
import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.model.TmsSellerExample;
import com.commerce.mall.service.TmsSellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
@Service
public class TmsSellerServiceImpl implements TmsSellerService {

    private Logger log = LoggerFactory.getLogger(TmsSellerServiceImpl.class);

    @Autowired
    private TmsSellerMapper tmsSellerMapper;

    @Autowired
    private TmsSellerDetailDao tmsSellerDetailDao;

    /**
     * 根据seller_id查找商家
     *
     * @param sellerId
     * @return
     */
    @Override
    public TmsSellerDetail getById(Integer sellerId) {
        return tmsSellerDetailDao.selectByPrimaryKey(sellerId);
    }

    /**
     * 添加商家
     *
     * @param tmsSeller
     * @return
     */
    @Override
    public int add(TmsSeller tmsSeller) {
        tmsSeller.setClosed("0");
        tmsSeller.setIsDelete("0");
        //todo TmsSellerParam UmsMemberReceiveAddress
        int i = tmsSellerMapper.insertSelective(tmsSeller);
        return i;
    }

    /**
     * 更改商家信息
     *
     * @param tmsSeller
     * @return
     */
    @Override
    public int update(TmsSeller tmsSeller) {
        //todo TmsSellerParam UmsMemberReceiveAddress
        TmsSellerExample tmsSellerExample = new TmsSellerExample();
        tmsSellerExample.createCriteria().andSellerIdEqualTo(tmsSeller.getSellerId());
        return tmsSellerMapper.updateByExampleSelective(tmsSeller, tmsSellerExample);
    }

    /**
     * 获取商家列表
     *
     * @return
     */
    @Override
    public List<TmsSellerDetail> list() {
        return null;
    }

    /**
     * 分页显示卖家列表
     *
     * @param pageNum
     * @param pageSize
     * @param keyWord
     * @return
     */
    @Override
    public PageInfo<TmsSellerDetail> pagedList(int pageNum, int pageSize, String keyWord) {
        PageHelper.startPage(pageNum, pageSize);
        TmsSellerExample tmsSellerExample = new TmsSellerExample();
        TmsSellerExample.Criteria criteria = tmsSellerExample.createCriteria();
        if (!StrUtil.isEmpty(keyWord)) {
            criteria.andSellerNameLike(keyWord);
        }
        tmsSellerExample.setOrderByClause("seller_id asc");
        List<TmsSellerDetail> tmsSellers = tmsSellerDetailDao.selectByExampleWithBLOBs(tmsSellerExample);
        return new PageInfo<>(tmsSellers);
    }

    /**
     * 更改商家isDelete
     *
     * @param sellerId
     * @param isDelete
     * @return
     */
    @Override
    public int updateAttrIsDelete(Integer sellerId, String isDelete) {
        return tmsSellerDetailDao.updateAttrIsDelete(sellerId, isDelete);
    }

    /**
     * 更改商家closed
     *
     * @param sellerId
     * @param closed
     * @return
     */
    @Override
    public int updateAttrClosed(Integer sellerId, String closed) {
        return tmsSellerDetailDao.updateAttrClosed(sellerId, closed);
    }
}