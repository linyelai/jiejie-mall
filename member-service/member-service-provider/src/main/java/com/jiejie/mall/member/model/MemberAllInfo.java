package com.jiejie.mall.member.model;

import lombok.Data;

import java.util.Date;

@Data
public class MemberAllInfo {
    private Integer id;
    private String memberName;//会员名
    private String password;//密码
    private String personIdNum;//身份证号码
    private Integer level;//等级
    private String nickName;//昵称
    private String phoneNum;//手机号码
    private Integer status;//状态
    private String createTime;//创建时间
    private String avatar;//头像图标地址
    private Integer gender;//性别 1 ：男 2：女
    private String birthday;//生日
    private Integer provinceId;//省份id
    private Integer cityId;//城市id
    private Integer areaId;//地区id
    private String email;//email
}
