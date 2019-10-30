package com.jiejie.mall.web.biz;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.request.MemberRequest;
import com.jiejie.mall.member.response.MemberInfoResponse;
import com.jiejie.mall.member.service.MemberService;
import com.jiejie.mall.token.request.CreateTokenRequest;
import com.jiejie.mall.token.service.TokenService;
import com.jiejie.mall.web.controller.request.LoginWebRequest;
import com.jiejie.mall.web.controller.request.RegistryMemberWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import com.jiejie.mall.web.controller.response.LoginWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class MemberBiz {

 //@Reference(version = "1.0.02-SNAPSHOT" ,group = "jiejie.mall.member",check = false)
  private MemberService memberService;
 //@Reference(version = "1.0",group = "" ,check=false)
 private TokenService tokenService;
  public Response<Boolean> registryMember(RegistryMemberWebRequest webRequest) {
      //检查是否已经存在会员
      Response<Boolean> response = new Response<Boolean>();
      MemberRequest  memberRequest = BeanCopyUtil.copyProperties(MemberRequest.class,webRequest);
      Response<MemberInfoResponse>  memberInfoResponseResponse = memberService.findMemberByName(memberRequest);
      if(memberInfoResponseResponse.getData()!=null){
            response.setData(false);
            response.setErrorMsg("该会员已经注册！");

      }
      else {
          AddMemberRequest request = BeanCopyUtil.copyProperties(AddMemberRequest.class, webRequest);
          response = memberService.addMember(request);
      }
      return response;
  }

  public  Response<LoginWebResponse> login(LoginWebRequest webRequest, HttpServletResponse response){

      Response<LoginWebResponse> loginWebResponseResponse = new Response<>();
      String memberName = webRequest.getUsername();
      MemberRequest request = new MemberRequest();
      request.setMemberName(memberName);
      Response<MemberInfoResponse> memberInfoResponse = memberService.findMemberByName(request);
      if(memberInfoResponse.getData()!=null){
          MemberInfoResponse memberInfoResponse1 = memberInfoResponse.getData();
          String passwordTemp = memberInfoResponse1.getPassword();
          if(passwordTemp.equals(webRequest.getPassword())){
              //生成token
              CreateTokenRequest createTokenRequest = new CreateTokenRequest();
              String token = UUID.randomUUID().toString();
              createTokenRequest.setToken(token);
              createTokenRequest.setTokenValue("");
              Response<Boolean> tokenResponse = tokenService.createToken(createTokenRequest);
              //将token保存写到header中
              if(tokenResponse.getData())
              {
                  response.setHeader("token",token);
              }
          }
      }
      return loginWebResponseResponse;
  }
}
