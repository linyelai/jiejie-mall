package com.jiejie.mall.web.biz;

import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.service.MemberService;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class MemberBiz {

 @Reference(version = "1.0.02" ,group = "jiejie.mall.member",check = false)
  private MemberService memberService;
  public CommonWebResponse<String> registryMember() {
      AddMemberRequest request = new AddMemberRequest();
      memberService.registryMember(request);
      return null;
  }
}
