package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;
import com.commerce.mall.model.TmsFoodPicsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TmsFoodPicsMapper {

    long countByExample(TmsFoodPicsExample example);

    int deleteByExample(TmsFoodPicsExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(TmsFoodPics record);

    int insertSelective(TmsFoodPics record);

    List<TmsFoodPics> selectByExample(TmsFoodPicsExample example);

    TmsFoodPics selectByPrimaryKey(Integer picId);

    /**
     * 查找一个商品的主图
     *
     * @param foodId food id
     * @return main pic
     */
    TmsFoodPics selectMainPic(Integer foodId);

    /**
     * 查一个商品的所有图
     * @param foodId food id
     * @return all pictures
     */
    List<TmsFoodPics> selectAllPics(Integer foodId);

    int updateByExampleSelective(@Param("record") TmsFoodPics record, @Param("example") TmsFoodPicsExample example);

    int updateByExample(@Param("record") TmsFoodPics record, @Param("example") TmsFoodPicsExample example);

    int updateByPrimaryKeySelective(TmsFoodPics record);

    int updateByPrimaryKey(TmsFoodPics record);
}