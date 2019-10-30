package com.jiejie.mall.web.controller.order.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderWebResponse {
    private String productName;
    private String productImg;
    private Integer count;
    private String orderSn;
    private String reciever;
    private String recieverPhone;
    private BigDecimal totalMoney;
    private BigDecimal price;
    private String memberRemark;
    private Integer status;
    private Date createTime;
}
