package com.jiejie.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfo {
    private Integer id;
    private String orderSn;
    private BigDecimal totalMoney;
    private Integer status;
    private Date createTime;
}
