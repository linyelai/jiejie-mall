package com.jiejie.mall.auth.service;

import com.jiejie.mall.auth.request.AddRoleRequest;
import com.jiejie.mall.auth.request.DeleteRoleRequest;

import javax.xml.ws.Response;

/**
 * 角色服务
 */
public interface RoleService {
    /**
     * 新增角色
     * @param request
     * @return
     */
    public Response<Boolean> addRole(AddRoleRequest request);

    /**
     * 删除角色
     * @param request
     * @return
     */
    public Response<Boolean> deleteRole(DeleteRoleRequest request);
}
