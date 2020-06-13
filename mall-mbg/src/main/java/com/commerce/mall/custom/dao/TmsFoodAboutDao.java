package com.commerce.mall.custom.dao;

import com.commerce.mall.custom.dto.TmsFoodWithMainPic;
import com.commerce.mall.custom.dto.TmsFoodWithPics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.06
 */
public interface TmsFoodAboutDao {

    /**
     * 获取某食物的销量
     *
     * @param foodId
     * @return
     */
    int selectSales(Integer foodId);
}
