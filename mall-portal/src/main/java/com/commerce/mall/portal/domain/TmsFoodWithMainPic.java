package com.commerce.mall.portal.domain;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public class TmsFoodWithMainPic extends TmsFood {

    private static final long serialVersionUID = 1591171709422390836L;

    private TmsFoodPics mainPic;

    @Override
    public String toString() {
        return super.toString() + "TmsFoodInHome{" +
                "tmsFoodPic=" + mainPic +
                '}';
    }

    public TmsFoodPics getTmsFoodPic() {
        return mainPic;
    }

    public void setTmsFoodPic(TmsFoodPics tmsFoodPic) {
        this.mainPic = tmsFoodPic;
    }
}
