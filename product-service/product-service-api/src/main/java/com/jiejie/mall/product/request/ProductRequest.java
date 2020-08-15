package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductRequest extends BaseRequest {
    private Integer id;
    private String productSpu;
    private String productName;
    private String productMainImg;//商品主图
    private Date updateTime;
    private Integer status;
    private BigDecimal discount;//折扣
    private Integer productCateId;//类别id
    private Integer productBrandId;//品牌id
    private String description;

}
