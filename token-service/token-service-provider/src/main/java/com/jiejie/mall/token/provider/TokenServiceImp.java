package com.jiejie.mall.token.provider;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.token.biz.TokenBiz;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.service.TokenService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author linyelai
 * @desc token服务
 * @Date 2019-10-02
 */
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}")
public class TokenServiceImp implements TokenService {

    @Autowired
    private TokenBiz tokenBiz;
    public Response<Boolean> createToken(CreateTokenRequest request){
       return tokenBiz.createToken(request);
    }

}
