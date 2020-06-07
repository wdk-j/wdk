package com.commerce.mall.service;


import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.model.TmsFood;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     *
     * @param files images
     * @param tmsFood food
     * @return code
     */
    int add(MultipartFile[] files,TmsFood tmsFood);

    /**
     * 删除商品
     *
     * @param foodId food id
     * @return code
     */
    int delete(Integer foodId);
}