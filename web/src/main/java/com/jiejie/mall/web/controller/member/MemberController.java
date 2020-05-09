package com.jiejie.mall.web.controller.member;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.MemberBiz;
import com.jiejie.mall.web.controller.member.request.MemberUpdateWebRequest;
import com.jiejie.mall.web.controller.request.LoginWebRequest;
import com.jiejie.mall.web.controller.request.RegistryMemberWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import com.jiejie.mall.web.controller.response.LoginWebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * @Desc 会员
 * @Author linyelai
 * @Date 2019-10-03
 */
@RestController
@Api(value = "会员")
public class MemberController {

    @Autowired
    private MemberBiz memberBiz;
    /**
     * 会员注册
     * @return
     */
    @PostMapping("/member/registry")
    @ApiOperation(value = "会员注册")
    public Response<Boolean> registryMember(RegistryMemberWebRequest webRequest){

      return   memberBiz.registryMember( webRequest);

    }
    @PostMapping("/member/login")
    @ApiOperation(value = "登录")
    public Response<LoginWebResponse> login(LoginWebRequest webRequest, HttpServletResponse response){

        //
        return memberBiz.login(webRequest,response);


    }

    @PutMapping("/member")
    public Response<Boolean> update(MemberUpdateWebRequest webRequest){

        //
        return memberBiz.update(webRequest);


    }

}
