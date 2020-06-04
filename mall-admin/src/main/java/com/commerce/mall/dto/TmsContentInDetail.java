package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFoodComments;
import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

public class TmsContentInDetail extends TmsFoodComments {

    private static final long serialVersionUID = 470704436347727463L;

    private List<TmsFoodCommentsPics> tmsFoodCommentsPics;

    public TmsContentInDetail(){
        super();
    }

    @Override
    public String toString() {
        return "TmsContentInDetail{" +
                "tmsFoodCommentsPics=" + tmsFoodCommentsPics +
                '}';
    }

    public List<TmsFoodCommentsPics> getTmsFoodCommentsPics() {
        return tmsFoodCommentsPics;
    }

    public void setTmsFoodCommentsPics(List<TmsFoodCommentsPics> tmsFoodCommentsPics) {
        this.tmsFoodCommentsPics = tmsFoodCommentsPics;
    }
}
