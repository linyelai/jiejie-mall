package com.jiejie.mall.product.request;

import lombok.Data;


@Data
public class GoodsRequest {

    private Integer id;
    private Integer productId;
    private String goodsName;
    private String goodsSku;
}
