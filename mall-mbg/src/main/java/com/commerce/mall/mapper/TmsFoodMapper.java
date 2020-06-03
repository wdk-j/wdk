package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TmsFoodMapper {

    long countByExample(TmsFoodExample example);

    int deleteByExample(TmsFoodExample example);

    int deleteByPrimaryKey(Integer foodId);

    int insert(TmsFood record);

    int insertSelective(TmsFood record);

    List<TmsFood> selectByExample(TmsFoodExample example);

    TmsFood selectByPrimaryKey(Integer foodId);

    int updateByExampleSelective(@Param("record") TmsFood record, @Param("example") TmsFoodExample example);

    int updateByExample(@Param("record") TmsFood record, @Param("example") TmsFoodExample example);

    int updateByPrimaryKeySelective(TmsFood record);

    int updateByPrimaryKey(TmsFood record);
}