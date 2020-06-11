package com.commerce.mall.service;

import com.commerce.mall.model.TmsAdvertising;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TmsAdvertisingService {

    int add(TmsAdvertising tmsAdvertising);

    int update(TmsAdvertising tmsAdvertising);

    int delete(Integer id);

    TmsAdvertising get(Integer id);

    int updateAdSort(Integer sort, Integer id);

    int updateAdIsDelete(String isDelete, Integer id);

    int updateAdIsDeleteInBatch(String isDelete, List<Integer> ids);

    PageInfo<TmsAdvertising> listAdvertising(int pageNum , int pageSize , String keyWord);
}
