package com.jiejie.mall.member.service;

import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.response.BaseResponse;
import com.jiejie.mall.member.response.MemberInfoResponse;

public interface MemberService {
     public BaseResponse<Boolean> registryMember(AddMemberRequest request);

     public BaseResponse<MemberInfoResponse> findMemberByName(String memberName);
}
