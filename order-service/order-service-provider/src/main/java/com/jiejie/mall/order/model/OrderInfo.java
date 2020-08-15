package com.jiejie.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderInfo {
    private Integer id;
    private String orderSn;
    private Integer shopId;
    private Integer memberId;
    private String reciever;
    private String recieverPhone;
    private String shopName;
    private String memberName;
    private BigDecimal totalMoney;
    private Integer status;
    private Date createTime;
    private List<GoodsOrderInfo> goodsOrderInfoList;
}
