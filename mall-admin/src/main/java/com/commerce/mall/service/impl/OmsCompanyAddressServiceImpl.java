package com.commerce.mall.service.impl;

import com.commerce.mall.mapper.OmsCompanyAddressMapper;
import com.commerce.mall.model.OmsCompanyAddress;
import com.commerce.mall.model.OmsCompanyAddressExample;
import com.commerce.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by commerce on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {

    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
