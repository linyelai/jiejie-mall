package com.jiejie.mall.member.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UpdateMemberInfoRequest extends BaseRequest  {
    private Integer id;
    private String memberName;
    private String password;
    private Integer level;
    private String nickName;
    private String phone;
    private Integer status;
    private Date createTime;
    private String cavatar;
    private Integer gender;
    private Date birthday;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String email;
}
