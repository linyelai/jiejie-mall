package com.jiejie.mall.web.controller;

import com.jiejie.mall.web.biz.MemberBiz;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import com.jiejie.mall.web.controller.response.RegistryMemberWebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CommonWebResponse<String> registryMember(){
        CommonWebResponse<String> result = new CommonWebResponse<String>();
        memberBiz.registryMember();
        result.setResult("注册成功");
        return result;
    }

}
