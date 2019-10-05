package com.jiejie.mall.member.service;

import com.jiejie.mall.common.response.BaseResponse;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.request.DeleteMemberRequest;
import com.jiejie.mall.member.request.UpdateMemberInfoRequest;
import com.jiejie.mall.member.response.MemberInfoResponse;

public interface MemberService {
     public BaseResponse<Boolean> addMember(AddMemberRequest request);

     public BaseResponse<MemberInfoResponse> findMemberByName(String memberName);

     public BaseResponse<Boolean> updateMemberInfo(UpdateMemberInfoRequest request);

     public BaseResponse<Boolean> deleteMemberInfo(DeleteMemberRequest request);
}
