package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsFoodComments;
import com.commerce.mall.model.TmsFoodCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsFoodCommentsMapper {
    long countByExample(TmsFoodCommentsExample example);

    int deleteByExample(TmsFoodCommentsExample example);

    int deleteByPrimaryKey(Integer commId);

    int insert(TmsFoodComments record);

    int insertSelective(TmsFoodComments record);

    List<TmsFoodComments> selectByExampleWithBLOBs(TmsFoodCommentsExample example);

    List<TmsFoodComments> selectByExample(TmsFoodCommentsExample example);

    TmsFoodComments selectByPrimaryKey(Integer commId);

    int updateByExampleSelective(@Param("record") TmsFoodComments record, @Param("example") TmsFoodCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") TmsFoodComments record, @Param("example") TmsFoodCommentsExample example);

    int updateByExample(@Param("record") TmsFoodComments record, @Param("example") TmsFoodCommentsExample example);

    int updateByPrimaryKeySelective(TmsFoodComments record);

    int updateByPrimaryKeyWithBLOBs(TmsFoodComments record);

    int updateByPrimaryKey(TmsFoodComments record);
}