package com.jiejie.mall.auth.mapper;

import com.jiejie.mall.auth.model.AuthInfo;
import com.jiejie.mall.auth.model.AuthPageParam;

import java.util.List;
import java.util.Map;

public interface AuthMapper {

    public int addAuth(AuthInfo authInfo);
    public int deleteAuth(Integer id);
    public int updateAuth(AuthInfo authInfo);
    public List<AuthInfo> findAuthInfoByIds(List<Integer> ids);
    public AuthInfo findAuthInfoById(Integer id);
    public List<AuthInfo> findAuthByPage(Map param);
}
