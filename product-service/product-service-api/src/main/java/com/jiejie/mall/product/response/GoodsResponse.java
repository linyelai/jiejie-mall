package com.jiejie.mall.product.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsResponse {
    private Integer id;
    private String goodsName;
    private String goodsSku;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
}
