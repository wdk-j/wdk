package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;

/**
 * @author jiangyong
 * @date 2020.06.04
 */
public class TmsFoodWithMainPic extends TmsFood {

    private static final long serialVersionUID = 437522082041119119L;

    private TmsFoodPics mainPic;

    public TmsFoodWithMainPic() {
        super();
    }

    @Override
    public String toString() {
        return super.toString()+"TmsFoodWithMainPic{" +
                "mainPic=" + mainPic +
                '}';
    }

    public TmsFoodPics getMainPic() {
        return mainPic;
    }

    public void setMainPic(TmsFoodPics mainPic) {
        this.mainPic = mainPic;
    }
}
