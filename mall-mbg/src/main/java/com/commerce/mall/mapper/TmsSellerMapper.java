package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.model.TmsSellerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TmsSellerMapper {

    long countByExample(TmsSellerExample example);

    int deleteByExample(TmsSellerExample example);

    int deleteByPrimaryKey(Integer sellerId);

    int insert(TmsSeller record);

    int insertSelective(TmsSeller record);

    List<TmsSeller> selectByExampleWithBLOBs(TmsSellerExample example);

    List<TmsSeller> selectByExample(TmsSellerExample example);

    TmsSeller selectByPrimaryKey(Integer sellerId);

    int updateByExampleSelective(@Param("record") TmsSeller record, @Param("example") TmsSellerExample example);

    int updateByExampleWithBLOBs(@Param("record") TmsSeller record, @Param("example") TmsSellerExample example);

    int updateByExample(@Param("record") TmsSeller record, @Param("example") TmsSellerExample example);

    int updateByPrimaryKeySelective(TmsSeller record);

    int updateByPrimaryKeyWithBLOBs(TmsSeller record);

    int updateByPrimaryKey(TmsSeller record);

}