package com.jiejie.mall.member.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MemberInfoResponse  implements Serializable {
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
    private Date birthday;
    private Integer provinceId;
    private Integer cityId;
    private Integer areaId;
    private String email;

}
