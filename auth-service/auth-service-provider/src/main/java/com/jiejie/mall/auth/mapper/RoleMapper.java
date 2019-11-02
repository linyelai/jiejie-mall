package com.jiejie.mall.auth.mapper;

import com.jiejie.mall.auth.model.RoleInfo;
import com.jiejie.mall.auth.model.RolePageParam;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    public int addRole(RoleInfo role);
    public  int deleteRole(Integer id);
    public int updateRole(RoleInfo role);
    public RoleInfo findRoleById(Integer id);
    public List<RoleInfo> findRoleByPage(Map map);
}
