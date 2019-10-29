package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.PageRequest;
import lombok.Data;

@Data
public class ProductPageRequest extends PageRequest {

    private String productName;
    private Integer shopId;

}
