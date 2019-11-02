package com.jiejie.mall.auth.provider;

import com.jiejie.mall.auth.mapper.AuthMapper;
import com.jiejie.mall.auth.model.AuthInfo;
import com.jiejie.mall.auth.request.AddAuthRequest;
import com.jiejie.mall.auth.request.AuthPageRequest;
import com.jiejie.mall.auth.request.AuthRequest;
import com.jiejie.mall.auth.request.DeleteAuthRequest;
import com.jiejie.mall.auth.response.AuthResponse;
import com.jiejie.mall.auth.service.AuthService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class AuthServiceImp  implements AuthService {

    @Autowired
    private AuthMapper authMapper;
    /**
     * 给角色分配权限
     * @param roleId
     * @param authsId
     * @return
     */
    public Response<Boolean> addAuthToRole(Integer roleId, List<Integer> authsId){


        return null;
    }

    /**
     * 删除角色权限
     * @param roleId
     * @param authsId
     * @return
     */
    public Response<Boolean> deleteAuthFromRole(Integer roleId,List<Integer> authsId){

        return null;
    }

    /**
     * 新增权限
     * @param request
     * @return
     */
    public Response<Boolean> addAuth(AddAuthRequest request){

        Response<Boolean> response = new Response<>();
        AuthInfo authInfo = BeanCopyUtil.copyProperties(AuthInfo.class,request);
        int result  = authMapper.addAuth(authInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }

    /**
     * 删除权限
     * @param request
     * @return
     */
    public Response<Boolean> deleteAuth(DeleteAuthRequest request){

        Response<Boolean> response = new Response<>();
        Integer id = request.getId();
        int result = authMapper.deleteAuth(id);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }
    /**
     *
     * @param request
     * @return
     */
    public Response<Boolean> updateAuth(AuthRequest request){

        Response<Boolean> response = new Response<>();
        AuthInfo authInfo = BeanCopyUtil.copyProperties(AuthInfo.class,request);
        int result = authMapper.updateAuth(authInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public Response<AuthResponse> findAuthInfoById(AuthRequest request){

        Response<AuthResponse> response = new Response<>();
        Integer id = request.getId();
        AuthInfo authInfo = authMapper.findAuthInfoById(id);
        AuthResponse authResponse = BeanCopyUtil.copyProperties(AuthResponse.class,authInfo);
        response.setData(authResponse);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public PageResponse<AuthResponse> findAuthByPage(AuthPageRequest request){
        PageResponse<AuthResponse> response = new PageResponse<>();
        Map param = new HashMap();
        param.put("name",request.getName());
        param.put("platform",request.getPlatform());
        param.put("currentPage",request.getCurrentPage());
        param.put("pageSize",request.getPageSize());
        List<AuthInfo> authInfoList = authMapper.findAuthByPage(param);
        List<AuthResponse> authResponses = BeanCopyUtil.copyList(AuthResponse.class,authInfoList);
        response.setData(authResponses);
        return response;
    }

}
