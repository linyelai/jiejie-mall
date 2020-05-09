package com.jiejie.mall.shop.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class ShopRequest extends BaseRequest {

    private String shopName;
    private Integer id;
}
