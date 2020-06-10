package com.commerce.mall.service;


import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.dto.TmsFoodWithPicsResult;
import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;
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
    PageInfo<TmsFoodWithMainPic> listFoods(int pageNum, int pageSize, Integer sellerId, String keyword);

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    TmsFoodWithPicsResult get(Integer foodId);

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
     * @param foodIds  food id
     * @return code
     */
    int updateAttrIsDeleteInBatch(String isDelete, List<Integer> foodIds);

    /**
     * 更新isOff字段
     *
     * @param isOff is off
     * @param foodId   food id
     * @return code
     */
    int updateAttrIsOff(String isOff, Integer foodId);

    /**
     * 批量更新isOff字段
     *
     * @param isOff is off
     * @param foodIds  food id
     * @return code
     */
    int updateAttrIsOffInBatch(String isOff, List<Integer> foodIds);

    /**
     * 更新食品
     *
     * @param tmsFoodWithPicsResult food
     * @return code status
     */
    int update(TmsFoodWithPicsResult tmsFoodWithPicsResult);

    /**
     * 添加食品
     *
     * @param tmsFoodWithPicsResult tmsFoodWithPicsResult
     * @return code
     */
    int add(TmsFoodWithPicsResult tmsFoodWithPicsResult);

    /**
     * 删除商品
     *
     * @param foodId food id
     * @return code
     */
    int delete(Integer foodId);
}