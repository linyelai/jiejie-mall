package com.jiejie.mall.auth.provider;

import com.jiejie.mall.auth.mapper.RoleMapper;
import com.jiejie.mall.auth.model.RoleInfo;
import com.jiejie.mall.auth.request.*;
import com.jiejie.mall.auth.response.RoleResponse;
import com.jiejie.mall.auth.service.RoleService;
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
public class RoleServiceImp  implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 新增角色
     * @param request
     * @return
     */
    public Response<Boolean> addRole(AddRoleRequest request){

        Response<Boolean> response = new Response<>();
        RoleInfo roleInfo = BeanCopyUtil.copyProperties(RoleInfo.class,request);
        int result = roleMapper.addRole(roleInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
         return response;
    }

    /**
     * 删除角色
     * @param request
     * @return
     */
    public Response<Boolean> deleteRole(DeleteRoleRequest request){

        Response<Boolean> response = new Response<>();
        Integer id = request.getId();
        int result =  roleMapper.deleteRole(id);
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
    public Response<RoleResponse> findRoleById(RoleRequest request){
        Response<RoleResponse> response = new Response<>();
        Integer id = request.getId();
        RoleInfo roleInfo = roleMapper.findRoleById(id);
        RoleResponse roleResponse = BeanCopyUtil.copyProperties(RoleResponse.class,roleInfo);
        response.setData(roleResponse);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public PageResponse<RoleResponse> findRoleByPage(RolePageRequest request){

        PageResponse<RoleResponse> response = new PageResponse<>();
        Map param = new HashMap();
         param.put("name",request.getName());
         param.put("platform",request.getPlatform());
         param.put("currentPage",request.getCurrentPage());
         param.put("pageSize",request.getPageSize());
         List<RoleInfo> roleInfoList= roleMapper.findRoleByPage(param);
         List<RoleResponse> responseList = BeanCopyUtil.copyList(RoleResponse.class,roleInfoList);
         response.setData(responseList);
        return response;
    }

    /**
     *
     * @param request
     * @return
     */
    public Response<Boolean> updateRole(UpdateRoleRequest request){

        Response<Boolean> response = new Response<>();
        RoleInfo roleInfo = BeanCopyUtil.copyProperties(RoleInfo.class,request);
        int result = roleMapper.updateRole(roleInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }
}
