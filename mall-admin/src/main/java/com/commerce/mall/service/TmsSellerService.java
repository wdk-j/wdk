package com.commerce.mall.service;

import com.commerce.mall.model.TmsSeller;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsSellerService {

    TmsSeller getTmsSellerById(Integer sellerId);

    int addTmsSeller(TmsSeller tmsSeller);

    int updateTmsSeller(TmsSeller tmsSeller);

    List<TmsSeller> list();
    PageInfo<TmsSeller> pagedList(int pageNum , int pageSize ,String keyWord);

    int updateAttrIsDelete(Integer sellerId ,String isDelete);

    int deleteTmsSellerById(Integer sellerId);

    int updateAttrClosed(Integer sellerId, String closed);
}