package com.jiejie.mall.product.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class ProductRequest extends BaseRequest {

    private String productName;
    private Integer shopId;

}
