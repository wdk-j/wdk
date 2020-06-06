package com.commerce.mall.custom.dto;

import com.commerce.mall.model.TmsSeller;
import com.commerce.mall.model.UmsMemberReceiveAddress;

/**
 * @author jiangyong
 * @date 2020.06.06
 */
public class TmsSellerDetail extends TmsSeller {

    private static final long serialVersionUID = 120229372132353051L;

    private UmsMemberReceiveAddress address;

    @Override
    public String toString() {
        return super.toString() + "TmsSellerDetail{" +
                "address=" + address +
                '}';
    }

    public UmsMemberReceiveAddress getAddress() {
        return address;
    }

    public void setAddress(UmsMemberReceiveAddress address) {
        this.address = address;
    }
}
