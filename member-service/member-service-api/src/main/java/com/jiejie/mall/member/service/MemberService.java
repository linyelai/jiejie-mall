package com.jiejie.mall.member.service;

import com.jiejie.mall.common.response.BaseResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.member.request.AddMemberRequest;
import com.jiejie.mall.member.request.DeleteMemberRequest;
import com.jiejie.mall.member.request.MemberPageRequest;
import com.jiejie.mall.member.request.UpdateMemberInfoRequest;
import com.jiejie.mall.member.response.MemberInfoResponse;

public interface MemberService {
     public Response<Boolean> addMember(AddMemberRequest request);

     public Response<MemberInfoResponse> findMemberByName(String memberName);

     public Response<Boolean> updateMemberInfo(UpdateMemberInfoRequest request);

     public Response<Boolean> deleteMemberInfo(DeleteMemberRequest request);

     public PageResponse<MemberInfoResponse> findMemberByPage(MemberPageRequest request);
}
