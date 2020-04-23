package com.jiejie.mall.web.controller.order.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailWebResponse {
    private Integer id;
    private Integer shopId;
    private String orderNum;
    private String mainOrderNum;
    private BigDecimal totalMoney;

}
