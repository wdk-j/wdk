package com.commerce.mall.custom.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.08
 */
public interface TmsAdvertisingAboutDao {
    /**
     * 单独修改is_delete字段
     *
     * @param isDelete
     * @param id
     * @return
     */
    int updateIsDelete(@Param("isDelete") String isDelete, @Param("id") Integer id);

    /**
     * 批量修改is_delete字段
     *
     * @param isDelete
     * @param ids
     * @return
     */
    int updateIsDeleteInBatch(@Param("isDelete") String isDelete, @Param("ids") List<Integer> ids);
}
