package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddProductRequest  extends BaseRequest {

    private String productName;
    private String productSku;
    private String productMainImg;//商品主图
    private Integer shopId;//商店id
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private BigDecimal discount;//折扣
    private Integer goodsCateId;//类别id
    private Integer goodsBrandId;//品牌id

}
