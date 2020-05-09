package com.jiejie.mall.web.controller.goods.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author linseven
 * @Date 2020/5/5
 */

@Data
public class GoodsWebResponse {

    private Integer id;
    private Integer productId;
    private String goodsName;
    private String sku;
    private String spu;
    private BigDecimal goodsPrice;
    private BigDecimal goodsSellPrice;
    private String goodsImgs;
    private Date createTime;
    private Date updateTime;
    private Integer stock;
    private String description;
    private Integer status;
}
