package com.commerce.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.commerce.mall.dao.TmsAdvertisingAboutDao;
import com.commerce.mall.mapper.TmsAdvertisingMapper;
import com.commerce.mall.model.TmsAdvertising;
import com.commerce.mall.model.TmsAdvertisingExample;
import com.commerce.mall.service.TmsAdvertisingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmsAdvertisingServiceImpl implements TmsAdvertisingService {

    private Logger log = LoggerFactory.getLogger(TmsAdvertisingServiceImpl.class);

    @Autowired
    private TmsAdvertisingMapper tmsAdvertisingMapper;

    @Autowired
    private TmsAdvertisingAboutDao tmsAdvertisingAboutDao;

    /**
     * 添加广告
     *
     * @param tmsAdvertising
     * @return
     */
    @Override
    public int add(TmsAdvertising tmsAdvertising) {
        tmsAdvertising.setIsDelete("0");
        return tmsAdvertisingMapper.insertSelective(tmsAdvertising);
    }

    /**
     * 修改广告
     *
     * @param tmsAdvertising
     * @return
     */
    @Override
    public int update(TmsAdvertising tmsAdvertising) {
        TmsAdvertisingExample tmsAdvertisingExample = new TmsAdvertisingExample();
        tmsAdvertisingExample.createCriteria().andIdEqualTo(tmsAdvertising.getId());
        return tmsAdvertisingMapper.updateByExampleSelective(tmsAdvertising, tmsAdvertisingExample);
    }

    /**
     * 删除广告
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return tmsAdvertisingMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取广告信息
     *
     * @param id
     * @return
     */
    @Override
    public TmsAdvertising get(Integer id) {
        return tmsAdvertisingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateAdSort(Integer sort, Integer id) {
        return tmsAdvertisingAboutDao.updateSort(sort, id);
    }

    /**
     * ，上下架广告，更新isDelete
     *
     * @param isDelete
     * @param id
     * @return
     */
    @Override
    public int updateAdIsDelete(String isDelete, Integer id) {
        return tmsAdvertisingAboutDao.updateIsDelete(isDelete, id);
    }

    /**
     * 批量上下架，更新isDelete
     *
     * @param isDelete
     * @param ids
     * @return
     */
    @Override
    public int updateAdIsDeleteInBatch(String isDelete, List<Integer> ids) {
        return tmsAdvertisingAboutDao.updateIsDeleteInBatch(isDelete, ids);
    }

    /**
     * 分页显示广告列表
     *
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public PageInfo<TmsAdvertising> listAdvertising(int pageNum, int pageSize, String keyword) {
        // sort排
        String orderByClause = "sort desc";
        TmsAdvertisingExample example = new TmsAdvertisingExample();
        TmsAdvertisingExample.Criteria criteria = example.createCriteria();
        if (!StrUtil.isEmpty(keyword)) {
            criteria.andAdDescLike('%' + keyword + '%');
        }
        example.setOrderByClause(orderByClause);
        PageHelper.startPage(pageNum, pageSize);
        List<TmsAdvertising> advertising = tmsAdvertisingMapper.selectByExample(example);
        return new PageInfo<>(advertising);
    }
}
