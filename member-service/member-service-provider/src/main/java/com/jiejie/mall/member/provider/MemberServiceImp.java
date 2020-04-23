package com.jiejie.mall.member.provider;

import com.jiejie.mall.common.response.BaseResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.common.utils.BusinessException;
import com.jiejie.mall.member.mapper.MemberMapper;
import com.jiejie.mall.member.model.MemberAllInfo;
import com.jiejie.mall.member.model.MemberInfo;
import com.jiejie.mall.member.request.*;
import com.jiejie.mall.member.response.MemberInfoResponse;
import com.jiejie.mall.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    public Response<Boolean> addMember(AddMemberRequest request){
        Response<Boolean> response = new Response<Boolean>();
        //查看是否已经存在了该会员
        String memberName = request.getMemberName();
        MemberAllInfo memberAllInfo = memberMapper.findMemberByName(memberName);
        if(memberAllInfo!=null){
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("该会员已经存在，请换个手机号码注册");
        }else{
            MemberInfo memberInfo = BeanCopyUtil.copyProperties(MemberInfo.class,request);
            int insertRow = memberMapper.addMember(memberInfo);
            if(insertRow<=0){
                log.error("注册会员信息异常，会员手机号码:{}",memberName);
                throw new BusinessException("程序异常");
            }else{
                response.setSuccess(true);
                response.setData(true);
            }
        }
        return response;
    }

    public Response<MemberInfoResponse> findMemberByName(MemberRequest request){
        Response<MemberInfoResponse> response =new Response<MemberInfoResponse>();
        MemberAllInfo memberAllInfo = memberMapper.findMemberByName(request.getMemberName());
        if(memberAllInfo!=null) {
            MemberInfoResponse memberInfoResponse = BeanCopyUtil.copyProperties(MemberInfoResponse.class, memberAllInfo);
            response.setData(memberInfoResponse);
        }else{
            response.setErrorMsg("can not find the memberinfo!");
        }
        return  response;
    }
    public Response<Boolean> updateMemberInfo(UpdateMemberInfoRequest request){
        Response<Boolean> response = new Response<Boolean>();
        //查看会员信息是否存在
        Integer id = request.getId();
        if(id!=null) {
            MemberAllInfo oldMemberAllInfo = memberMapper.findMemberById(id);
            if(oldMemberAllInfo==null){
                response.setSuccess(false);
                response.setData(false);
                response.setErrorMsg("更新的会员不存在");
            }
        }else{
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("缺少会员id");
        }
        MemberAllInfo memberAllInfo = BeanCopyUtil.copyProperties(MemberAllInfo.class,request);
        int updateRow = memberMapper.updateMember(memberAllInfo);
        if(updateRow<=0){
            log.error("更新会员信息异常，会员手机号码:{}",request);
            throw new BusinessException("程序异常");
        }else{
            response.setData(true);
            response.setSuccess(true);
        }
        return response;
    }
    public Response<Boolean> deleteMemberInfo(DeleteMemberRequest request){
        Response<Boolean> response = new Response<Boolean>();
        Integer id = request.getId();
        if(id!=null) {
            MemberAllInfo oldMemberAllInfo = memberMapper.findMemberById(id);
            if(oldMemberAllInfo==null){
                response.setSuccess(false);
                response.setData(false);
                response.setErrorMsg("更新的会员不存在");
            }
        }else{
            response.setSuccess(false);
            response.setData(false);
            response.setErrorMsg("缺少会员id");
        }
        int deleteRow = memberMapper.deleteMember(id);
        if(deleteRow<=0){
            log.error("删除会员信息异常，会员手机号码:{}",request);
            throw new BusinessException("程序异常");
        }else{
            response.setData(true);
            response.setSuccess(true);
        }
        return response;
    }

    public PageResponse<MemberInfoResponse> findMemberByPage(MemberPageRequest request){

        return null;
    }

}
