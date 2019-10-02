package com.jiejie.mall.token.request;

import lombok.Data;

@Data
public class BaseRequest {
    private String trackId;//跟踪id
    private Integer currentUserId;//当前用户id
    private String currentUsername;//当前用户名
}
