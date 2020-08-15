package com.jiejie.mall.web.biz.member;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.common.utils.Md5;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.request.MemberRequest;
import com.jiejie.mall.member.response.MemberInfoResponse;
import com.jiejie.mall.member.service.MemberService;
import com.jiejie.mall.token.service.TokenService;
import com.jiejie.mall.web.controller.member.request.MemberPageRequest;
import com.jiejie.mall.web.controller.member.request.MemberResponse;
import com.jiejie.mall.web.controller.request.LoginWebRequest;
import com.jiejie.mall.web.controller.request.RegistryMemberWebRequest;
import com.jiejie.mall.web.controller.response.LoginWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class MemberBiz {

 @Reference(version = "1.0.02-SNAPSHOT" ,group = "jiejie.mall.member",check = false)
 private MemberService memberService;
 @Reference(version = "1.0-SNAPSHOT",group = "jiejie.mall.token" ,check=false)
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

  public  Response<LoginWebResponse> login(@RequestBody  LoginWebRequest webRequest, HttpServletResponse response){

      Response<LoginWebResponse> loginWebResponseResponse = new Response<>();
      String memberName = webRequest.getUsername();
      MemberRequest request = new MemberRequest();
      request.setMemberName(memberName);
      Response<MemberInfoResponse> memberInfoResponse = memberService.findMemberByName(request);
      if(memberInfoResponse.getData()!=null){
          MemberInfoResponse memberInfoResponse1 = memberInfoResponse.getData();
          String passwordTemp = memberInfoResponse1.getPassword();
          try {
              String paramPass = Md5.EncoderByMd5(webRequest.getPassword());
              if(paramPass.equals(passwordTemp)){
                  loginWebResponseResponse.setSuccess(true);
              }else{
                  loginWebResponseResponse.setSuccess(false);

              }
          }catch(NoSuchAlgorithmException e){
              e.printStackTrace();
          }catch (UnsupportedEncodingException e){
              e.printStackTrace();
          }
          if(passwordTemp.equals(webRequest.getPassword())){
              //生成token
              /*CreateTokenRequest createTokenRequest = new CreateTokenRequest();
              String token = UUID.randomUUID().toString();
              createTokenRequest.setToken(token);
              createTokenRequest.setTokenValue("");
              Response<Boolean> tokenResponse = tokenService.createToken(createTokenRequest);
              //将token保存写到header中
              if(tokenResponse.getData())
              {
                  response.setHeader("token",token);
              }*/
          }
      }
      return loginWebResponseResponse;
  }

    public  PageResponse<MemberResponse> findMemberByPage(@RequestBody MemberPageRequest webRequest, HttpServletResponse response){

        PageResponse<MemberResponse> loginWebResponseResponse = new PageResponse<>();
        String memberName = webRequest.getMemberName();
        MemberRequest request = new MemberRequest();
        request.setMemberName(memberName);
        com.jiejie.mall.member.request.MemberPageRequest pageRequest = BeanCopyUtil.copyProperties(com.jiejie.mall.member.request.MemberPageRequest.class,request);
        PageResponse<MemberInfoResponse> memberInfoResponse = memberService.findMemberByPage(pageRequest);
        return loginWebResponseResponse;
    }



}
