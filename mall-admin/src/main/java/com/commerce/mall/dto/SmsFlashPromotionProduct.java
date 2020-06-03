package com.commerce.mall.dto;

import com.commerce.mall.model.PmsProduct;
import com.commerce.mall.model.SmsFlashPromotionProductRelation;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by commerce on 2018/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {

    @Getter
    @Setter
    private PmsProduct product;
}
