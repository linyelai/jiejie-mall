package com.jiejie.mall.web.controller.product.request;

import com.jiejie.mall.token.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductWebRequest extends BaseRequest {
    private String productName;//商品名称
    private String productImg;//商品图片
    private BigDecimal price;//价格
    private Integer stock;//库存
    private Integer cateId;//类别id
    private Integer brandId;// 品牌id
    private Integer logisticsId;//收货地址id;
    private String desc;
}
