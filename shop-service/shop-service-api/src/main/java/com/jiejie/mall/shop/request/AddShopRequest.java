package com.jiejie.mall.shop.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/8/16
 */
@Data
public class AddShopRequest implements Serializable {
    private String shopName;
    private String legalPersonName;
    private String legalPersonIdNum;
    private String legalPersonPhone;
    private String licenseCode;
    private String licenseImg;
    private Integer status;
    private Date createTime;
    private String logo;
}

