package com.jiejie.mall.auth.provider;

import com.jiejie.mall.auth.request.AddAuthRequest;
import com.jiejie.mall.auth.request.DeleteAuthRequest;
import com.jiejie.mall.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.xml.ws.Response;
import java.util.List;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class AuthServiceImp  implements AuthService {

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

        return null;
    }

    /**
     * 删除权限
     * @param request
     * @return
     */
    public Response<Boolean> deleteAuth(DeleteAuthRequest request){

        return null;
    }

}
