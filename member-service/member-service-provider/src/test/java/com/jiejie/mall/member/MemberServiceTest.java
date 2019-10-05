package com.jiejie.mall.member;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.jiejie.mall.member.biz.MemberBiz;
import com.jiejie.mall.member.model.MemberInfo;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.service.MemberService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class MemberServiceTest {
   /* @Reference(version = "1.0.02-SNAPSHOT" ,group = "jiejie.mall.member",check = false)
    private MemberService memberService;*/
   @Autowired
   private MemberBiz memberBiz;
   @Value("${spring.datasource.url}")
   private String url;
   @Value("${mybatis.type.aliasesPackage}")
    private String typeAliasesPackage;
    @Test
    public void registryMemeber(){
        AddMemberRequest request = new AddMemberRequest();
        request.setMemberName("18312483564");
        request.setPassword("123456");
        //memberService.registryMember(request);
      //  memberService.findMemberByName("18312483564");

    }
    @Test
    public void findMemeberByNameTest(){
       MemberInfo memberInfo =  memberBiz.findMemberByName("18312483564");
       System.out.println(memberInfo.toString());
       System.out.println(typeAliasesPackage);
    }
}
