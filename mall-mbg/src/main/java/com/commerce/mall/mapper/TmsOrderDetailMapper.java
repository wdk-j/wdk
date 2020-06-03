package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsOrderDetail;
import com.commerce.mall.model.TmsOrderDetailExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TmsOrderDetailMapper {

    long countByExample(TmsOrderDetailExample example);

    int deleteByExample(TmsOrderDetailExample example);

    int deleteByPrimaryKey(Integer odId);

    int insert(TmsOrderDetail record);

    int insertSelective(TmsOrderDetail record);

    List<TmsOrderDetail> selectByExample(TmsOrderDetailExample example);

    TmsOrderDetail selectByPrimaryKey(Integer odId);

    int updateByExampleSelective(@Param("record") TmsOrderDetail record, @Param("example") TmsOrderDetailExample example);

    int updateByExample(@Param("record") TmsOrderDetail record, @Param("example") TmsOrderDetailExample example);

    int updateByPrimaryKeySelective(TmsOrderDetail record);

    int updateByPrimaryKey(TmsOrderDetail record);
}