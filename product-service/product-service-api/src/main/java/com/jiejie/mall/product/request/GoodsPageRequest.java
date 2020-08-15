package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

/**
 * @Author linseven
 * @Date 2020/7/11
 */
@Data
public class GoodsPageRequest extends PageRequest {

    private String goodsName;
    private Integer productId;
}
