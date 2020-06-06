package com.commerce.mall.custom.dao;


import com.commerce.mall.custom.dto.TmsSellerDetail;
import com.commerce.mall.model.TmsSellerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.06
 */
public interface TmsSellerDetailDao {

    /**
     * 主键查
     *
     * @param sellerId
     * @return
     */
    TmsSellerDetail selectByPrimaryKey(Integer sellerId);

    /**
     * 模糊查所有字段
     *
     * @param keyword
     * @return
     */
    List<TmsSellerDetail> selectByExampleWithBLOBs(@Param("keyword") String keyword,@Param("orderByClause")String orderByClause);

    /**
     * 修改商家的is_delete
     *
     * @param sellerId
     * @param isDelete
     * @return
     */

    int updateAttrIsDelete(@Param("sellerId") Integer sellerId, @Param("isDelete") String isDelete);

    /**
     * 修改商家的closed
     *
     * @param sellerId
     * @param closed
     * @return
     */

    int updateAttrClosed(@Param("sellerId") Integer sellerId, @Param("closed") String closed);
}