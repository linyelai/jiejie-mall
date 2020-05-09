package com.jiejie.mall.web.controller.sku.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuResponse {
    private Long id;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private String desc;
    private Long sellerId;
}
