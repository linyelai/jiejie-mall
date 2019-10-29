package com.jiejie.mall.auth.request;

import lombok.Data;

import java.util.Date;

@Data
public class AddRoleRequest {
    private  Integer platfom;
    private  String roleName;
    private String desc;//描述
    private Date createTime;
    private Date updateTime;
}
