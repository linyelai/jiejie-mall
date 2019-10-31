package com.jiejie.mall.product.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsInfo {
    private Integer id;
    private String goodsName;
    private String sku;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Date createTime;
    private Date updateTime;
}
