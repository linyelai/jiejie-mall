package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/7/11
 */
@Data
public class UpdateGoodsRequest extends BaseRequest {
    private Integer id;
    private Integer productId;
    private String goodsName;
    private String goodsSku;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Date updateTime;
    private String description;
    private Integer status;
    private Integer stock;
}
