package com.jiejie.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsOrderInfo {
    private Integer id;
    private String goodOrderSn;
    private String orderSn;
    private String goodsName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalMoney;
    private String reciever;
    private String recieverPhone;
    private String address;
    private Date createTime;
    private String sku;
    private BigDecimal discount;
    private BigDecimal sellPrice;
    private String orderImg;
}

