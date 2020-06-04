package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public class TmsFoodDetail extends TmsFood {

    private static final long serialVersionUID = 5788675020116388439L;

    private List<TmsFoodPics> pics;

    public TmsFoodDetail() {
        super();
    }

    @Override
    public String toString() {
        return super.toString()+"TmsFoodDetail{" +
                "pics=" + pics +
                '}';
    }

    public List<TmsFoodPics> getPics() {
        return pics;
    }

    public void setPics(List<TmsFoodPics> pics) {
        this.pics = pics;
    }
}
