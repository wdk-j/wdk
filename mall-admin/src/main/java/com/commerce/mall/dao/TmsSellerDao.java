package com.commerce.mall.dao;

import org.apache.ibatis.annotations.Param;

@Deprecated
public interface TmsSellerDao {

    /**
     * 修改商家的is_delete
     * @param sellerId
     * @param isDelete
     * @return
     */

    int updateAttrIsDelete(@Param("sellerId") Integer sellerId , @Param("isDelete") String isDelete);

    /**
     * 修改商家的closed
     * @param sellerId
     * @param closed
     * @return
     */

    int updateAttrClosed(@Param("sellerId") Integer sellerId , @Param("closed") String closed);
}
