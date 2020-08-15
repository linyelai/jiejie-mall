package com.jiejie.mall.web.controller.member;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.member.MemberBiz;
import com.jiejie.mall.web.controller.member.request.MemberPageRequest;
import com.jiejie.mall.web.controller.member.request.MemberResponse;
import com.jiejie.mall.web.controller.request.LoginWebRequest;
import com.jiejie.mall.web.controller.request.RegistryMemberWebRequest;
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
@RequestMapping("/member")
@Api(value = "会员")
public class MemberController {

    @Autowired
    private MemberBiz memberBiz;
    /**
     * 会员注册
     * @return
     */
    @PostMapping("/registry")
    @ApiOperation(value = "会员注册")
    public Response<Boolean> registryMember(RegistryMemberWebRequest webRequest){

      return   memberBiz.registryMember( webRequest);

    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    @ResponseBody
    public Response<LoginWebResponse> login(@RequestBody LoginWebRequest webRequest, HttpServletResponse response){

        //
        return memberBiz.login(webRequest,response);


    }
    @PostMapping("/findMemberByPage")
    @ApiOperation(value = "登录")
    @ResponseBody
    public PageResponse<MemberResponse> findMemberByPage(@RequestBody MemberPageRequest webRequest, HttpServletResponse response){
        //
        return memberBiz.findMemberByPage(webRequest,response);


    }


}
