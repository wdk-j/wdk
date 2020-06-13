package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.custom.dao.TmsSellerDetailDao;
import com.commerce.mall.custom.dto.TmsSellerDetail;
import com.commerce.mall.dto.TmsSellerParam;
import com.commerce.mall.mapper.TmsSellerMapper;
import com.commerce.mall.mapper.UmsMemberReceiveAddressMapper;
import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.model.TmsSellerExample;
import com.commerce.mall.model.UmsMemberReceiveAddress;
import com.commerce.mall.model.UmsMemberReceiveAddressExample;
import com.commerce.mall.service.TmsSellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

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
     * @param tmsSellerParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(TmsSellerParam tmsSellerParam) {
        tmsSellerParam.setClosed("0");
        tmsSellerParam.setIsDelete("0");
        TmsSeller tmsSeller = new TmsSeller();
        // bean转接
        BeanUtils.copyProperties(tmsSellerParam,tmsSeller);
        String address = tmsSellerParam.getDetailAddress();
        if (address == null) {
            address = "未填写";
        }
        UmsMemberReceiveAddress receiveAddress = new UmsMemberReceiveAddress();
        receiveAddress.setDetailAddress(address);
        // 插入地址
        umsMemberReceiveAddressMapper.insertSelective(receiveAddress);
        // 设定返回的addrId
        tmsSeller.setAddrId(receiveAddress.getId());
        //todo TmsSellerParam UmsMemberReceiveAddress
        return tmsSellerMapper.insertSelective(tmsSeller);
    }

    /**
     * 更改商家信息
     *
     * @param tmsSellerParam
     * @return
     */
    @Override
    public int update(TmsSellerParam tmsSellerParam) {
        TmsSeller tmsSeller = new TmsSeller();
        // bean转接
        BeanUtils.copyProperties(tmsSellerParam,tmsSeller);

        String address = tmsSellerParam.getDetailAddress();
        if (address == null) {
            address = "未填写";
        }
        UmsMemberReceiveAddress receiveAddress = new UmsMemberReceiveAddress();

        receiveAddress.setId(tmsSellerParam.getAddrId());
        receiveAddress.setDetailAddress(address);

        umsMemberReceiveAddressMapper.updateByPrimaryKeySelective(receiveAddress);
        return tmsSellerMapper.updateByPrimaryKeySelective(tmsSeller);
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
     * @param keyword
     * @return
     */
    @Override
    public PageInfo<TmsSellerDetail> pagedList(int pageNum, int pageSize, String keyword) {
        if (StrUtil.isEmpty(keyword)) {
            keyword = null;
        }else {
            keyword='%'+keyword+'%';
        }
        String orderByClause = "seller_id asc";
        PageHelper.startPage(pageNum, pageSize);
        List<TmsSellerDetail> tmsSellers = tmsSellerDetailDao.selectByExampleWithBLOBs(keyword, orderByClause);
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

    @Override
    public int updateAttrIsDeleteInBatch(List<Integer> sellerIds, String isDelete) {
        return tmsSellerDetailDao.updateAttrIsDeleteInBatch(sellerIds, isDelete);
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