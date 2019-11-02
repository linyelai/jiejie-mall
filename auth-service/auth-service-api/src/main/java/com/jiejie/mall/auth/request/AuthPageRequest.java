package com.jiejie.mall.auth.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class AuthPageRequest extends PageRequest {
    private Integer id;
    private String name;//权限名称
    private Integer platform;//平台
}
