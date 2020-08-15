package com.jiejie.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsOrderInfo {
    private Integer id;
    private String goodOrderSn;
    private String productName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private BigDecimal totalMoney;
    private String goodsImg;
    private String productImg;
    private Date createTime;
}
