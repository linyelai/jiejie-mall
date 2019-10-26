package com.jiejie.mall.auth.model;

import lombok.Data;

import java.util.Date;

@Data
public class RoleInfo {
    private Integer id;
    private String name;
    private Integer platform;
    private String desc;
    private Date createTime;
    private Date updateTime;
}
