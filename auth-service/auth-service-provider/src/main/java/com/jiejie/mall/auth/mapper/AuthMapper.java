package com.jiejie.mall.auth.mapper;

import com.jiejie.mall.auth.model.AuthInfo;
import com.jiejie.mall.auth.model.AuthPageParam;

import java.util.List;

public interface AuthMapper {

    public int addAuth(AuthInfo authInfo);
    public int deleteAuth(AuthInfo authInfo);
    public int updateAuth(AuthInfo authInfo);
    public List<AuthInfo> findAuthInfoByIds(List<Integer> ids);
    public AuthInfo findAuthInfoById(Integer id);
    public List<AuthInfo> findAuthByPage(AuthPageParam authPageParam);
}
