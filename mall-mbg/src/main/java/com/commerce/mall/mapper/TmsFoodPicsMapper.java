package com.commerce.mall.mapper;

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

    int updateByExampleSelective(@Param("record") TmsFoodPics record, @Param("example") TmsFoodPicsExample example);

    int updateByExample(@Param("record") TmsFoodPics record, @Param("example") TmsFoodPicsExample example);

    int updateByPrimaryKeySelective(TmsFoodPics record);

    int updateByPrimaryKey(TmsFoodPics record);
}