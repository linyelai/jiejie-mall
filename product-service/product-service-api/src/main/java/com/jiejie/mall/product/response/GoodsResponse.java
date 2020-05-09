package com.jiejie.mall.product.response;

import com.jiejie.mall.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsResponse extends BaseResponse {
    private Integer id;
    private String goodsName;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private String description;
    private Integer productId;
    private String sku;
    private String spu;
    private Date createTime;
    private Date updateTime;
    private Integer stock;
    private Integer status;
}
