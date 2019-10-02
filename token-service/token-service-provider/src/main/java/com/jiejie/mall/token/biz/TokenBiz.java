package com.jiejie.mall.token.biz;

import com.jiejie.mall.token.constant.TokenConstant;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.response.BaseResponse;
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
    public BaseResponse<Boolean> createToken(CreateTokenRequest request){
        BaseResponse<Boolean>  response = new BaseResponse<Boolean>();
        String tokenValue = request.getTokenValue();
        String token = request.getToken();
        redisUtil.setValue(token,tokenValue,expiredTime);
        if(redisUtil.getValue(token)!=null){
            response.setSuccess(true);
            response.setResult(true);
        }
        else{
            response.setSuccess(false);
            response.setResult(false);
        }
        return response;
    }
}
