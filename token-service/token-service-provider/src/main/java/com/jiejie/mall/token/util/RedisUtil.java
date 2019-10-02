package com.jiejie.mall.token.util;

import com.jiejie.mall.token.constant.TokenConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
   @Autowired
    private ValueOperations<String, Object> valueOperations;
    public void  setValue(String key,Object value,Long expiredTime){
         valueOperations.set(TokenConstant.TOKEN_KEY_PREFIX+key,value,expiredTime);
    }
   public Object getValue(String key){
        return valueOperations.get(TokenConstant.TOKEN_KEY_PREFIX+key);
    }
}
