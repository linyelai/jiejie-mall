package com.jiejie.mall.auth.service;

import com.jiejie.mall.auth.request.AddAuthRequest;
import com.jiejie.mall.auth.request.DeleteAuthRequest;

import javax.xml.ws.Response;
import java.util.List;

/**
 * 权限服务
 */
public interface AuthService {
    /**
     * 给角色分配权限
     * @param roleId
     * @param authsId
     * @return
     */
    public Response<Boolean> addAuthToRole(Integer roleId, List<Integer> authsId);

    /**
     * 删除角色权限
     * @param roleId
     * @param authsId
     * @return
     */
    public Response<Boolean> deleteAuthFromRole(Integer roleId,List<Integer> authsId);

    /**
     * 新增权限
     * @param request
     * @return
     */
    public Response<Boolean> addAuth(AddAuthRequest request);

    /**
     * 删除权限
     * @param request
     * @return
     */
    public Response<Boolean> deleteAuth(DeleteAuthRequest request);

}
