package com.jiejie.mall.shop.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class UpdateShopRequest extends BaseRequest  {
    private Integer id;
    private String shopName;
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
