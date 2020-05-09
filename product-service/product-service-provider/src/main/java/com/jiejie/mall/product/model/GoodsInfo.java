package com.jiejie.mall.product.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsInfo {
    private Integer id;
    private Integer productId;
    private String goodsName;
    private String sku;
    private String spu;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Date createTime;
    private Date updateTime;
    private Integer stock;
    private String description;
    private Integer status;
}
