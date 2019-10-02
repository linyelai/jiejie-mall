package com.jiejie.mall.token.request;

import lombok.Data;

@Data
public class CreateTokenRequest extends  BaseRequest {
    private String tokenValue;//token数据结构 key --value
    private String token;
}
