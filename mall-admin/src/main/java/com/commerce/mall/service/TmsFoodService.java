package com.commerce.mall.service;


import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import com.commerce.mall.model.TmsFood;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * pc端service基本按照table本身来的，没有app的detail环节
 *
 * @author jy
 * @date 2020/6/3
 */
public interface TmsFoodService {

    /**
     * 分页
     * 获取某卖家商品列表
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param sellerId seller id
     * @param keyword  keyword
     * @return a page of food
     */
    PageInfo<TmsFoodWithMainPic> listFoods(int pageNum, int pageSize,Integer sellerId, String keyword);

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    TmsFoodWithPics get(Integer foodId);

    /**
     * 更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodId   food id
     * @return code
     */
    int updateAttrIsDelete(String isDelete, Integer foodId);

    /**
     * 批量更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodIds   food id
     * @return code
     */
    int updateAttrIsDeleteInBatch(String isDelete, List<Integer> foodIds);

    /**
     * 更新食品
     *
     * @param tmsFoodWithPics food
     * @return code status
     */
    int update(TmsFoodWithPics tmsFoodWithPics);

    /**
     * 添加食品
     *
     *
     * @param urls images
     * @param tmsFood food
     * @return code
     */
    int add(List<String> urls,TmsFood tmsFood);

    /**
     * 删除商品
     *
     * @param foodId food id
     * @return code
     */
    int delete(Integer foodId);
}