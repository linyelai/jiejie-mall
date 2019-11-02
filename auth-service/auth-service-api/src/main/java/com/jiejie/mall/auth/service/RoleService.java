package com.jiejie.mall.auth.service;

import com.jiejie.mall.auth.request.*;
import com.jiejie.mall.auth.response.RoleResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;

import javax.management.relation.RoleInfo;

import java.util.Map;

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

    /**
     *
     * @param request
     * @return
     */
    public Response<RoleResponse> findRoleById(RoleRequest request);

    /**
     *
     * @param request
     * @return
     */
    public PageResponse<RoleResponse> findRoleByPage(RolePageRequest request);

    /**
     *
     * @param roleInfo
     * @return
     */
    public Response<Boolean> updateRole(UpdateRoleRequest roleInfo);
}
