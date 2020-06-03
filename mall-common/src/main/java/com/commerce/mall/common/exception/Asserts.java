package com.commerce.mall.common.exception;

import com.commerce.mall.common.api.IErrorCode;
import com.commerce.mall.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by commerce on 2020/2/27.
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
