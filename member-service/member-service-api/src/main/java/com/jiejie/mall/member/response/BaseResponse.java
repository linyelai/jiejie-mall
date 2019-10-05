package com.jiejie.mall.member.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private final  static long id = 1L;
    private Integer errorCode;
    private Boolean success;
    private String errorMsg;
    private T result;
}
