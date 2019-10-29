package com.jiejie.mall.order.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsOrderResponse extends BaseResponse {

    private Integer id;
    private  String orderNum;
    private String  goodsOrderNum;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private BigDecimal goodsDiscount;
    private String goodsImg;
    private Integer goodsNum;
    private String goodsProductName;
    private List<SkuInfoResponse> skuInfo;

}
