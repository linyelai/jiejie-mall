package com.jiejie.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderInfo {
    private Integer id;
    private String orderSn;
    private BigDecimal totalMoney;
    private Integer status;
    private String createTime;
    private Integer productId;
    private GoodsOrderInfo goods;
    private Integer shopId;
    private Integer memberId;

}
