package com.jiejie.mall.product.response;

import lombok.Data;

@Data
public class BaseResponse <T>{
    private String errorMsg;
    private Boolean isSuccess;
    private T result;
}
