package com.jiejie.mall.web.controller.shop.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/8/16
 */
@Data
public class AddShopWebRequest {

    private Integer id;
    private String shopName;
    private String legalPersonName;
    private String legalPersonIdNum;
    private String legalPersonPhone;
    private String licenseCode;
    private String licenseImg;
    private Integer status;
    private String logo;

}
