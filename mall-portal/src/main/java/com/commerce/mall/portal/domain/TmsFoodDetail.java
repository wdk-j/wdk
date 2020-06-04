package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public class TmsFoodDetail extends TmsFood {

    private static final long serialVersionUID = 5788675020116388439L;

    private List<TmsFoodPics> tmsFoodPicsList;

    public TmsFoodDetail() {
        super();
    }

    @Override
    public String toString() {
        return super.toString()+"TmsFoodDetail{" +
                "tmsFoodPicsList=" + tmsFoodPicsList +
                '}';
    }

    public List<TmsFoodPics> getTmsFoodPicsList() {
        return tmsFoodPicsList;
    }

    public void setTmsFoodPicsList(List<TmsFoodPics> tmsFoodPicsList) {
        this.tmsFoodPicsList = tmsFoodPicsList;
    }
}
