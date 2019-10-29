package com.jiejie.mall.auth.model;

import lombok.Data;

import java.util.Date;

@Data
public class AuthInfo {

    private Integer id;
    private Integer parentId;
    private String name;
    private String url;
    private String resourceId;
    private Integer type;
    private Integer platform;
    private Integer sort;
    private Date createTime;
    private Date updateTime;
}
