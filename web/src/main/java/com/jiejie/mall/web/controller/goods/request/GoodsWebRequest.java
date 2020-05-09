package com.jiejie.mall.web.controller.goods.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsWebRequest  {
    private Integer id;
    private Integer productId;
    private String goodsName;
    private String sku;
    private String spu;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Integer stock;
    private String description;

}
