package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;


@Data
public class GoodsRequest  extends BaseRequest{

    private Integer id;
    private Integer productId;
    private String goodsName;
    private String goodsSku;
}
