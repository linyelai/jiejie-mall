package com.jiejie.mall.token.biz;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.token.constant.TokenConstant;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenBiz {
    @Autowired
    private RedisUtil redisUtil;
    @Value(TokenConstant.TOKEN_EXPIRED)
    private Long expiredTime;
    public Response<Boolean> createToken(CreateTokenRequest request){
        Response<Boolean>  response = new Response<Boolean>();
        String tokenValue = request.getTokenValue();
        String token = request.getToken();
        redisUtil.setValue(token,tokenValue,expiredTime);
        if(redisUtil.getValue(token)!=null){
            response.setSuccess(true);
            response.setData(true);
        }
        else{
            response.setSuccess(false);
            response.setData(false);
        }
        return response;
    }
}
