package com.liumce.mamabike.common.exception;

import com.liumce.mamabike.common.constants.Constants;

/**
 * Create by liumce on 18/08/10
 * 自定义业务异常
 */
public class MaMaBikeException extends Exception{

    public MaMaBikeException(String message) {
        super(message);
    }


    public int getStatusCode() {
        return Constants.RESP_STATUS_INTERNAL_ERROR;
    }
}
