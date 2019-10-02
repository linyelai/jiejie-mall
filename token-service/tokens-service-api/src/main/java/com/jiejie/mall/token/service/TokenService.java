package com.jiejie.mall.token.service;

import com.jiejie.mall.token.common.Token;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.response.BaseResponse;

public interface TokenService {

    public BaseResponse<Boolean> createToken(CreateTokenRequest request);

}
