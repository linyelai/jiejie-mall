package com.jiejie.mall.order.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsOrderResponse extends BaseResponse {

    private  Integer id;
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
