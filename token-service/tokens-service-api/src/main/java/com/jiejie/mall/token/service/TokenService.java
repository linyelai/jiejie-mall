package com.jiejie.mall.token.service;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.token.common.Token;
import com.jiejie.mall.token.request.CreateTokenRequest;


public interface TokenService {

    public Response<Boolean> createToken(CreateTokenRequest request);

}
