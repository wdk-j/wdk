package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.TmsCouponMapper;
import com.commerce.mall.model.TmsCoupon;
import com.commerce.mall.model.TmsCouponExample;
import com.commerce.mall.service.TmsCouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmsCouponServiceImpl implements TmsCouponService {

    @Autowired
    TmsCouponMapper tmsCouponMapper;

    /**
     * 分页显示平台满减
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public PageInfo<TmsCoupon> pagedList(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        TmsCouponExample tmsCouponExample = new TmsCouponExample();
        tmsCouponExample.setOrderByClause("id asc");
        List<TmsCoupon> tmsCoupons = tmsCouponMapper.selectByExample(tmsCouponExample);
        return new PageInfo<>(tmsCoupons);
    }

    /**
     * 添加平台满减
     * @param tmsCoupon
     * @return
     */
    @Override
    public int addTmsCoupon(TmsCoupon tmsCoupon) {
        return tmsCouponMapper.insertSelective(tmsCoupon);
    }

    /**
     * 删除平台满减
     * @param id
     * @return
     */
    @Override
    public int deleteTmsCoupon(Integer id) {
        return tmsCouponMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改平台满减
     * @param tmsCoupon
     * @return
     */
    @Override
    public int updateTmsCoupon(TmsCoupon tmsCoupon) {
        TmsCouponExample tmsCouponExample = new TmsCouponExample();
        tmsCouponExample.createCriteria().andIdEqualTo(tmsCoupon.getId());
        return tmsCouponMapper.updateByExampleSelective(tmsCoupon , tmsCouponExample);
    }

    /**
     * 根据id查询平台满减信息
     * @param id
     * @return
     */
    @Override
    public TmsCoupon getTmsCoupon(Integer id) {
        return tmsCouponMapper.selectByPrimaryKey(id);
    }

}
