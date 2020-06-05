package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsCoupon;
import com.commerce.mall.model.TmsCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsCouponMapper {
    long countByExample(TmsCouponExample example);

    int deleteByExample(TmsCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmsCoupon record);

    int insertSelective(TmsCoupon record);

    List<TmsCoupon> selectByExample(TmsCouponExample example);

    TmsCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmsCoupon record, @Param("example") TmsCouponExample example);

    int updateByExample(@Param("record") TmsCoupon record, @Param("example") TmsCouponExample example);

    int updateByPrimaryKeySelective(TmsCoupon record);

    int updateByPrimaryKey(TmsCoupon record);
}