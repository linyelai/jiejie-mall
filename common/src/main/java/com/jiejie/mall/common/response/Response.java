package com.jiejie.mall.common.response;

import lombok.Data;

@Data
public class Response<T>  extends  BaseResponse {
    private T data;
}
