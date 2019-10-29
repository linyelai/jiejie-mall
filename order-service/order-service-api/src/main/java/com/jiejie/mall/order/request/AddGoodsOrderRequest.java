package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddGoodsOrderRequest extends BaseRequest {

    private  String orderNum;
    private String  goodsOrderNum;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private BigDecimal goodsDiscount;
    private String goodsImg;
    private Integer goodsNum;


}
