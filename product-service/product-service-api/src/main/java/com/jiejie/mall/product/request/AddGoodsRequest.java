package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddGoodsRequest extends BaseRequest {
    private Integer productId;
    private String goodsName;
    private String sku;
    private String spu;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Integer stock;
    private String description;
}
