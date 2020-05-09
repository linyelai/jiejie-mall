package com.jiejie.mall.product.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductResponse extends BaseResponse {

    private Integer id;
    private String productName;
    private String productSpu;
    private String productImg;//商品主图
    private Integer shopId;//商店id
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private Integer productCateId;//类别id
    private Integer productBrandId;//品牌id
    private String description;

}
