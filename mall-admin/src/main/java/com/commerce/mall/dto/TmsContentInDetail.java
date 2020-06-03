package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFoodComments;
import com.commerce.mall.model.TmsFoodCommentsPics;

public class TmsContentInDetail extends TmsFoodComments {

    private static final long serialVersionUID = 470704436347727463L;

    private TmsFoodCommentsPics tmsFoodCommentsPics;

    public TmsContentInDetail(){
        super();
    }

    @Override
    public String toString() {
        return "TmsContentInDetail{" +
                "tmsFoodCommentsPics=" + tmsFoodCommentsPics +
                '}';
    }

    public TmsFoodCommentsPics getTmsFoodCommentsPics(){
        return tmsFoodCommentsPics;
    }

    public void setTmsFoodCommentsPics(TmsFoodCommentsPics tmsFoodCommentsPics){
        this.tmsFoodCommentsPics = tmsFoodCommentsPics;
    }
}
