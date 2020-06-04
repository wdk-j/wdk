package com.commerce.mall.service;

import com.commerce.mall.model.TmsSeller;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public interface TmsSellerService {

    TmsSeller getTmsSellerById(Integer sellerId);

    void addTmsSeller(TmsSeller tmsSeller);

    int updateTmsSeller(TmsSeller tmsSeller);

    void deleteTmsSellerById(Integer sellerId);
}