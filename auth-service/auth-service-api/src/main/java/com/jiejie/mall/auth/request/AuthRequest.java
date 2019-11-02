package com.jiejie.mall.auth.request;

import lombok.Data;

@Data
public class AuthRequest {
    private Integer id;
    private String name;//权限名称
    private Integer platform;//平台
}
