package com.jiejie.mall.member.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PerfectMemberInfoRequest implements Serializable {
    private final  static long id = 1L;
    private String memberName;
    private String password;
    private Integer level;
    private String nickName;
    private String phone;
    private Integer status;
    private Date createTime;
    private String icon;
    private Integer gender;
    private Date birthday;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String email;
}
