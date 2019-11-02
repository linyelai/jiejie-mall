package com.jiejie.mall.auth.response;

import lombok.Data;

import java.util.Date;

@Data
public class RoleResponse {
    private Integer id;
    private  Integer platfom;
    private  String roleName;
    private String desc;//描述
    private Date createTime;
    private Date updateTime;
}
