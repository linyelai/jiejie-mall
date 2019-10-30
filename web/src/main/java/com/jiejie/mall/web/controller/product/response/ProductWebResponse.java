package com.jiejie.mall.web.controller.product.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductWebResponse  {

    private String productName;//商品名称
    private String productImg;//商品图片
    private BigDecimal price;//价格
    private Integer stock;//库存
    private Integer cateId;//类别id
    private Integer brandId;// 品牌id
    private Integer logisticsId;//收货地址id;
    private String desc;
    private Integer status;//状态

}
