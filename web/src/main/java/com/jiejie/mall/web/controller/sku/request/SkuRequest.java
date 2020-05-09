package com.jiejie.mall.web.controller.sku.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuRequest {
    private Long id;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private String desc;
    private Long sellerId;

}
