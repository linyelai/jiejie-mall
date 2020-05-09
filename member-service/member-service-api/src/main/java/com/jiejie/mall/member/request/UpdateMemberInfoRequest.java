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
    private String personIdNum;//身份证号码
    private String phoneNum;
    private Integer status;
    private String avatar;
    private Integer gender;
    private String birthday;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String email;
}
