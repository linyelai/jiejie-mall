package com.jiejie.mall.web.test;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
/*import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.service.MemberService;*/
import com.jiejie.mall.web.Application;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
@EnableApolloConfig
public class MemberTest {
  /*  @Reference
    private MemberService memberService;*/
  @Value("${spring.dubbo.application.name}")
  private String port;
    @Test
    public void registryMemeber(){
       /* AddMemberRequest request = new AddMemberRequest();
        request.setMemberName("18312483564");
        request.setPassword("123456");
        memberService.registryMember(request);*/
        System.out.println(port);
    }
}
