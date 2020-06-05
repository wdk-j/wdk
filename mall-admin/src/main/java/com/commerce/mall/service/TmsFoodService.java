package com.commerce.mall.service;


import com.commerce.mall.dto.TmsFoodWithMainPic;
import com.commerce.mall.model.TmsFood;
import com.github.pagehelper.PageInfo;

/**
 * pc端service基本按照table本身来的，没有app的detail环节
 *
 * @author jy
 * @date 2020/6/3
 */
public interface TmsFoodService {

    /**
     * 分页
     * 获取商品列表
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param keyword  keyword
     * @return a page of food
     */
    PageInfo<TmsFoodWithMainPic> listFoods(int pageNum, int pageSize, String keyword);

    /**
     * 获取一个商品
     *
     * @param foodId foodId
     * @return food
     */
    TmsFoodWithMainPic get(Integer foodId);

    /**
     * 更新isDelete字段
     *
     * @param isDelete is delete
     * @param foodId   food id
     * @return code
     */
    int updateAttrIsDelete(String isDelete, Integer foodId);

    /**
     * 更新食品
     *
     * @param tmsFood food
     * @return code status
     */
    int update(TmsFood tmsFood);

    /**
     * 添加食品
     *
     * @param tmsFood food
     * @return code
     */
    int add(TmsFood tmsFood);

    /**
     * 删除商品
     *
     * @param foodId food id
     * @return code
     */
    int delete(Integer foodId);
}