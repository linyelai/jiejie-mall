package com.jiejie.mall.token.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer errorCode;
    private Boolean success;
    private String errorMsg;
    private T result;

}
