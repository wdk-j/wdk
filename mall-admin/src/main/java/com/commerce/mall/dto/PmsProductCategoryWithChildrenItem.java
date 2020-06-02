package com.commerce.mall.dto;

import com.commerce.mall.model.PmsProductCategory;

import java.util.List;

/**
 * Created by commerce on 2018/5/25.
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}
