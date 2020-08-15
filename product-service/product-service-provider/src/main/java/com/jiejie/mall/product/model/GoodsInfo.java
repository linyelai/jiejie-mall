package com.jiejie.mall.product.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsInfo {
    private Integer id;
    private Integer productId;
    private String goodsName;
    private String goodsSku;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Date createTime;
    private Date updateTime;
    private String description;
    private Integer status;
    private Integer stock;
}
