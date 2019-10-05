package com.jiejie.mall.member.biz;

import com.jiejie.mall.member.mapper.MemberMapper;
import com.jiejie.mall.member.model.MemberInfo;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.response.BaseResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberBiz {

    @Autowired
    private MemberMapper memberMapper;

    public BaseResponse<Boolean> registryMember(AddMemberRequest request){
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberName("18312483564");
        memberInfo.setPassword("123456");
        memberMapper.addMember(memberInfo);
        BaseResponse<Boolean> response = new BaseResponse<Boolean>();
        response.setSuccess(true);
        response.setResult(true);
        return response;

    }
    public MemberInfo findMemberByName(String memberName){
        return memberMapper.findMemberByName();
    }

}
