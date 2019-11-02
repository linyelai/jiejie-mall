package com.jiejie.mall.token;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.jiejie.mall.token.biz.TokenBiz;
import com.jiejie.mall.token.constant.TokenConstant;
import com.jiejie.mall.token.provider.TokenServiceImp;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.response.BaseResponse;
import com.jiejie.mall.token.service.TokenService;
import com.jiejie.mall.token.util.RedisUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class TokenTest {

    @Test
    public void testOne(){

    }
}
