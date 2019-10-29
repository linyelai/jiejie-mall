package com.jiejie.mall.web.controller.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

@Data
public class LoginWebResponse  extends BaseResponse{
    private String token;
}
