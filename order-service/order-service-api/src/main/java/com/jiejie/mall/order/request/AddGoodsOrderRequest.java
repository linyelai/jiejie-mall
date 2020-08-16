package com.jiejie.mall.order.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddGoodsOrderRequest extends BaseRequest implements Serializable {

    private String goodOrderSn;
    private String productName;
    private String sku;
    private Integer count;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private BigDecimal discount;
    private BigDecimal totalMoney;
    private String goodsImg;
    private String productImg;
    private String createTime;


}
