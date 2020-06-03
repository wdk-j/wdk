package com.commerce.mall.portal.service;

import com.commerce.mall.portal.domain.MemberBrandAttention;

import java.util.List;

/**
 * 会员关注Service
 * Created by commerce on 2018/8/2.
 */
public interface MemberAttentionService {

    /**
     * 添加关注
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     */
    int delete(Long memberId, Long brandId);

    /**
     * 获取用户关注列表
     */
    List<MemberBrandAttention> list(Long memberId);
}
