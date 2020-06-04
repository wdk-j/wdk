package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFoodComments;
import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public class TmsFoodCommentDetail extends TmsFoodComments {

    private String nickname;

    private String icon;

    private List<TmsFoodCommentsPics> tmsFoodCommentsPics;

    private static final long serialVersionUID = -5850708712994633469L;

    @Override
    public String toString() {
        return super.toString()+"TmsFoodCommentDetail{" +
                "nickname='" + nickname + '\'' +
                ", icon='" + icon + '\'' +
                ", tmsFoodCommentsPics=" + tmsFoodCommentsPics +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<TmsFoodCommentsPics> getTmsFoodCommentsPics() {
        return tmsFoodCommentsPics;
    }

    public void setTmsFoodCommentsPics(List<TmsFoodCommentsPics> tmsFoodCommentsPics) {
        this.tmsFoodCommentsPics = tmsFoodCommentsPics;
    }
}
