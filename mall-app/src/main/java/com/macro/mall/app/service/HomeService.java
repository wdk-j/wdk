package com.macro.mall.app.service;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;

import java.util.List;

public interface HomeService {
    List<PmsProductCategory> getProductCateList(Long parentId);

    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    List<PmsProduct> recommendProductListByPrice(Integer pageSize, Integer pageNum);
}
