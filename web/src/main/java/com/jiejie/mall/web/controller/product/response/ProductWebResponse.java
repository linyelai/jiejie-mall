package com.jiejie.mall.web.controller.product.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductWebResponse  {

    private String productName;//商品名称
    private String productImg;//商品图片
    private String description;
    private Integer status;//状态
    private Date createTime;
    private Date updateTime;
    private Integer productCateId;//类别id
    private Integer productBrandId;//品牌id

}
