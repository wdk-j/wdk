package com.commerce.mall.dao;

import com.commerce.mall.model.TmsFoodPics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.07
 */
public interface TmsFoodPicsDao {

    /**
     * 批量选择性地添加食物图
     *
     * @param pics food pics
     * @return effected rows
     */
    int insertSelectiveInBatch(@Param("pics") List<TmsFoodPics> pics);
}
