package com.jiejie.mall.web.controller.member.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/5/12
 */
@Data
public class MemberResponse {
    private final  static long id = 1L;
    private String memberName;
    private String password;
    private Integer level;
    private String nickName;
    private String phone;
    private Integer status;
    private Date createTime;
    private String cavatar;
    private Integer gender;
    private String birthday;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String email;
}
