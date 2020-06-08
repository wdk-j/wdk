package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsAdvertising;
import com.commerce.mall.model.TmsAdvertisingExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TmsAdvertisingMapper {

    long countByExample(TmsAdvertisingExample example);

    int deleteByExample(TmsAdvertisingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsAdvertising record);

    int insertSelective(TmsAdvertising record);

    List<TmsAdvertising> selectByExample(TmsAdvertisingExample example);

    TmsAdvertising selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsAdvertising record, @Param("example") TmsAdvertisingExample example);

    int updateByExample(@Param("record") TmsAdvertising record, @Param("example") TmsAdvertisingExample example);

    int updateByPrimaryKeySelective(TmsAdvertising record);

    int updateByPrimaryKey(TmsAdvertising record);
}