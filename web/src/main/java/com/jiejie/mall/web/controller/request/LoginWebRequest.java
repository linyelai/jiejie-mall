package com.jiejie.mall.web.controller.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class LoginWebRequest extends BaseRequest {
    private  String username;
    private String password;
}
