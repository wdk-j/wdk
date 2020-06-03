package com.commerce.mall.dto;

import com.commerce.mall.model.OmsCompanyAddress;
import com.commerce.mall.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 * Created by commerce on 2018/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {

    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
