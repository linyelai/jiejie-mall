package com.jiejie.mall.order.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsOrderInfo implements Serializable {
    private Integer id;
    private String goodOrderSn;
    private String orderSn;
    private String productName;
    private String sku;
    private Integer count;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private BigDecimal totalMoney;
    private String goodsImg;
    private String productImg;
    private Date createTime;
}
