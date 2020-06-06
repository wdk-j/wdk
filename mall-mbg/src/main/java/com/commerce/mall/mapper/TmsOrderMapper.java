package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsOrder;
import com.commerce.mall.model.TmsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsOrderMapper {
    long countByExample(TmsOrderExample example);

    int deleteByExample(TmsOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(TmsOrder record);

    int insertSelective(TmsOrder record);

    List<TmsOrder> selectByExample(TmsOrderExample example);

    TmsOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") TmsOrder record, @Param("example") TmsOrderExample example);

    int updateByExample(@Param("record") TmsOrder record, @Param("example") TmsOrderExample example);

    int updateByPrimaryKeySelective(TmsOrder record);

    int updateByPrimaryKey(TmsOrder record);
}