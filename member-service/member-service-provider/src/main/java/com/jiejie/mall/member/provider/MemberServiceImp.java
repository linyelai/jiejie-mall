package com.jiejie.mall.member.provider;

import com.jiejie.mall.member.biz.MemberBiz;
import com.jiejie.mall.member.model.MemberInfo;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.response.BaseResponse;
import com.jiejie.mall.member.response.MemberInfoResponse;
import com.jiejie.mall.member.service.MemberService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberBiz memberBiz;
    public BaseResponse<Boolean> registryMember(AddMemberRequest request){
        return memberBiz.registryMember(request);
    }

    public BaseResponse<MemberInfoResponse> findMemberByName(String memberName){
        BaseResponse<MemberInfoResponse> memberInfoResponse =new BaseResponse<MemberInfoResponse>();
         memberBiz.findMemberByName("18312483564");
         return  memberInfoResponse;
    }
}
