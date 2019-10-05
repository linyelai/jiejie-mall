package com.jiejie.mall.order.response;

import lombok.Data;

@Data
public class BaseResponse <T>{
    private String errorMsg;
    private Boolean success;
    private T result;
}
