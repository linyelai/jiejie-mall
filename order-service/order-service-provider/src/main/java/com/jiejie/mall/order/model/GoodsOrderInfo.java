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
    private BigDecimal totalMoney;
    private String reciever;
    private String recieverPhone;
    private Date createTime;
}
