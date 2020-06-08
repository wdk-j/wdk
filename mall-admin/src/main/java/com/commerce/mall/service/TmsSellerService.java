package com.commerce.mall.service;

import com.commerce.mall.custom.dto.TmsSellerDetail;
import com.commerce.mall.dto.TmsSellerParam;
import com.commerce.mall.model.TmsSeller;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsSellerService {

    TmsSellerDetail getById(Integer sellerId);

    int add(TmsSellerParam tmsSellerParam);

    int update(TmsSellerParam tmsSellerParam);

    List<TmsSellerDetail> list();

    PageInfo<TmsSellerDetail> pagedList(int pageNum, int pageSize, String keyWord);

    int updateAttrIsDelete(Integer sellerId, String isDelete);

    int updateAttrIsDeleteInBatch(List<Integer> sellerIds, String isDelete);

    int updateAttrClosed(Integer sellerId, String closed);
}