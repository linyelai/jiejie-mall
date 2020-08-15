package com.jiejie.mall.product.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductResponse {

    private Integer id;
    private String productName;
    private String productSpu;
    private String productMainImg;//商品主图
    private Integer shopId;//商店id
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private BigDecimal discount;//折扣
    private Integer productCateId;//类别id
    private Integer productBrandId;//品牌id

}
