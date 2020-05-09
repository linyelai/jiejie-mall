package com.jiejie.mall.web.controller.product.request;


import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductWebRequest extends BaseRequest {
    private String productName;//商品名称
    private String productSpu;//spu
    private String productImg;//商品图片
    private Integer shopId;
    private Integer productCateId;
    private Integer productBrandId;
    private String description;
}
