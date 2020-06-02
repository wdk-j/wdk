package com.commerce.mall.demo.service;

import com.commerce.mall.demo.dto.PmsBrandDto;
import com.commerce.mall.model.PmsBrand;
import com.commerce.mall.demo.dto.PmsBrandDto;
import com.commerce.mall.model.PmsBrand;

import java.util.List;

/**
 * DemoService接口
 */
public interface DemoService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrandDto pmsBrandDto);

    int updateBrand(Long id, PmsBrandDto pmsBrandDto);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
