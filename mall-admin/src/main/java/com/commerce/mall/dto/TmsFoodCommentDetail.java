package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFoodComments;
import com.commerce.mall.model.TmsFoodCommentsPics;

import java.util.List;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public class TmsFoodCommentDetail extends TmsFoodComments {

    private String nickname;

    private List<TmsFoodCommentsPics> commPics;

    private static final long serialVersionUID = -5850708712994633469L;

    @Override
    public String toString() {
        return super.toString()+"TmsFoodCommentDetail{" +
                "nickname='" + nickname + '\'' +
                ", commPics=" + commPics +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<TmsFoodCommentsPics> getCommPics() {
        return commPics;
    }

    public void setCommPics(List<TmsFoodCommentsPics> commPics) {
        this.commPics = commPics;
    }
}
