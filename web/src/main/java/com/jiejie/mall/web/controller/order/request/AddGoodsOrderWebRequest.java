package com.jiejie.mall.web.controller.order.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author linseven
 * @Date 2020/5/26
 */
@Data
public class AddGoodsOrderWebRequest {
    private String goodOrderSn;
    private String productName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private BigDecimal totalMoney;
    private String goodsImg;
    private String productImg;
    private String createTime;
}
