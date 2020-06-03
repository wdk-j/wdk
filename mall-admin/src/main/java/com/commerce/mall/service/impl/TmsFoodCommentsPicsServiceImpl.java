package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.TmsFoodCommentsPicsMapper;
import com.commerce.mall.model.TmsFoodCommentsPics;
import com.commerce.mall.model.TmsFoodCommentsPicsExample;
import com.commerce.mall.service.TmsFoodCommentsPicsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
@Service
public class TmsFoodCommentsPicsServiceImpl implements TmsFoodCommentsPicsService {

    private Logger log = LoggerFactory.getLogger(TmsFoodCommentsPicsServiceImpl.class);

    @Autowired
    private TmsFoodCommentsPicsMapper tmsFoodCommentsPicsMapper;

    /**
     * 获取某评论的配图列表
     *
     * @param commId comment id
     * @return pics
     */
    @Override
    public List<TmsFoodCommentsPics> getList(Integer commId) {
        TmsFoodCommentsPicsExample example = new TmsFoodCommentsPicsExample();
        example.createCriteria().andCommIdEqualTo(commId);
        return tmsFoodCommentsPicsMapper.selectByExample(example);
    }

    /**
     * 添加一张评论图
     *
     * @param tmsFoodCommentsPic tmsFoodCommentsPic
     */
    @Override
    public void add(TmsFoodCommentsPics tmsFoodCommentsPic) {
        tmsFoodCommentsPicsMapper.insert(tmsFoodCommentsPic);
    }
}