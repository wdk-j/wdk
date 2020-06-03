package com.commerce.mall.mapper;

import com.commerce.mall.model.TmsFoodCommentsPics;
import com.commerce.mall.model.TmsFoodCommentsPicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmsFoodCommentsPicsMapper {
    long countByExample(TmsFoodCommentsPicsExample example);

    int deleteByExample(TmsFoodCommentsPicsExample example);

    int deleteByPrimaryKey(Integer picId);

    int insert(TmsFoodCommentsPics record);

    int insertSelective(TmsFoodCommentsPics record);

    List<TmsFoodCommentsPics> selectByExample(TmsFoodCommentsPicsExample example);

    TmsFoodCommentsPics selectByPrimaryKey(Integer picId);

    int updateByExampleSelective(@Param("record") TmsFoodCommentsPics record, @Param("example") TmsFoodCommentsPicsExample example);

    int updateByExample(@Param("record") TmsFoodCommentsPics record, @Param("example") TmsFoodCommentsPicsExample example);

    int updateByPrimaryKeySelective(TmsFoodCommentsPics record);

    int updateByPrimaryKey(TmsFoodCommentsPics record);
}