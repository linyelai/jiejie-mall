package com.jiejie.mall.auth.response;

import lombok.Data;

@Data
public class AuthResponse {
    private Integer id;
    private Integer parentId; //父级权限
    private String name;//权限名称
    private String url;//url
    private String resourceId;//资源id
    private Integer type;//类型 0：按钮 1：菜单
    private Integer platform;//平台
    private Integer sort;//排序
}
