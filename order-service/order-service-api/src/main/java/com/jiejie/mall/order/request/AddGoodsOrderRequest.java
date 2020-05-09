package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddGoodsOrderRequest extends BaseRequest {

    private String goodOrderSn;
    private String orderSn;
    private String goodsName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalMoney;
    private String reciever;
    private String recieverPhone;
    private String address;
    private String sku;
    private BigDecimal discount;
    private BigDecimal sellPrice;
    private String orderImg;


}
