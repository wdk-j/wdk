package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.dao.TmsFoodCommentDetailDao;
import com.commerce.mall.dto.TmsFoodCommentDetail;
import com.commerce.mall.mapper.TmsFoodCommentsMapper;
import com.commerce.mall.mapper.TmsFoodCommentsPicsMapper;
import com.commerce.mall.model.TmsFoodCommentsPics;
import com.commerce.mall.model.TmsFoodCommentsPicsExample;
import com.commerce.mall.service.TmsFoodCommentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.05
 */
@Service
public class TmsFoodCommentsServiceImpl implements TmsFoodCommentsService {

    private Logger log = LoggerFactory.getLogger(TmsFoodCommentsServiceImpl.class);

    @Autowired
    private TmsFoodCommentsMapper tmsFoodCommentsMapper;

    @Autowired
    private TmsFoodCommentDetailDao tmsFoodCommentDetailDao;

    @Autowired
    private TmsFoodCommentsPicsMapper tmsFoodCommentsPicsMapper;

    /**
     * 分页查询
     * 关键查询
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @param keyword  keyword
     * @param sellerId seller id
     * @return list
     */
    @Override
    public PageInfo<TmsFoodCommentDetail> pagedList(int pageNum, int pageSize, String keyword, Integer sellerId) {
        //关键词查
        if (StrUtil.isEmpty(keyword)) {
            keyword = null;
        } else {
            keyword = '%' + keyword + '%';
        }
        PageHelper.startPage(pageNum, pageSize);
        List<TmsFoodCommentDetail> list = tmsFoodCommentDetailDao.selectCommentsDetailed(null, keyword, sellerId);
        // 封装pics
        TmsFoodCommentsPicsExample example;
        List<TmsFoodCommentsPics> fcp;
        for (TmsFoodCommentDetail fc : list) {
            example = new TmsFoodCommentsPicsExample();
            example.createCriteria().andCommIdEqualTo(fc.getCommId());
            fcp = tmsFoodCommentsPicsMapper.selectByExample(example);
            fc.setCommPics(fcp);
        }
        return new PageInfo<>(list);
    }

    /**
     * 获取某条评论
     *
     * @param commId comment id
     * @return comment
     */
    @Override
    public TmsFoodCommentDetail get(Integer commId) {
        TmsFoodCommentDetail fc = tmsFoodCommentDetailDao.selectByPrimaryKey(commId);

        // 封装图片
        TmsFoodCommentsPicsExample example = new TmsFoodCommentsPicsExample();
        example.createCriteria().andCommIdEqualTo(fc.getCommId());
        List<TmsFoodCommentsPics> fcp = tmsFoodCommentsPicsMapper.selectByExample(example);
        fc.setCommPics(fcp);
        return fc;
    }

    /**
     * 回复评论
     *
     * @param commId comment id
     * @param reply  replies
     * @return code
     */
    @Override
    public int reply(Integer commId, String reply) {
        return tmsFoodCommentDetailDao.updateReplyByPrimaryKey(commId, reply);
    }

    /**
     * 删除某条评论
     *
     * @param commId comment id
     * @return code
     */
    @Override
    public int delete(Integer commId) {
        TmsFoodCommentsPicsExample example = new TmsFoodCommentsPicsExample();
        example.createCriteria().andCommIdEqualTo(commId);
        tmsFoodCommentsPicsMapper.deleteByExample(example);
        return tmsFoodCommentsMapper.deleteByPrimaryKey(commId);
    }
}