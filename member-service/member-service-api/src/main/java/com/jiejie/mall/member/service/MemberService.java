package com.jiejie.mall.member.service;

import com.jiejie.mall.common.response.BaseResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.member.request.*;
import com.jiejie.mall.member.response.MemberInfoResponse;

public interface MemberService {
     public Response<Boolean> addMember(AddMemberRequest request);

     public Response<MemberInfoResponse> findMemberByName(MemberRequest request);

     public Response<Boolean> updateMemberInfo(UpdateMemberInfoRequest request);

     public Response<Boolean> deleteMemberInfo(DeleteMemberRequest request);

     public PageResponse<MemberInfoResponse> findMemberByPage(MemberPageRequest request);
}
