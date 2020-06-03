package com.commerce.mall.dto;

import com.commerce.mall.model.TmsFood;
import com.commerce.mall.model.TmsFoodPics;

/**
 * @author jiangyong
 * @date 2020.06.03
 */
public class TmsFoodInHome extends TmsFood {

    private static final long serialVersionUID = 1591171709422390836L;

    private TmsFoodPics mainPic;

    public TmsFoodInHome() {
        super();
    }

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
