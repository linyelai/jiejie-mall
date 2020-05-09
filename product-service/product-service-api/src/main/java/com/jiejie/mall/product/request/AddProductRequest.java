package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddProductRequest  extends BaseRequest {

    private Integer id;
    /** 商品名     */
    private String productName;
    private String productSpu;
    private String productImg;//商品主图
    private Integer shopId;//商店id
    private Integer status;
    private Integer productCateId;//类别id
    private Integer productBrandId;//品牌id
    private String description;

}
