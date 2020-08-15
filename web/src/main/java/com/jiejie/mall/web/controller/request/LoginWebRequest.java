package com.jiejie.mall.web.controller.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class LoginWebRequest extends BaseRequest {
    private  String username;
    private String password;
    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;
}
