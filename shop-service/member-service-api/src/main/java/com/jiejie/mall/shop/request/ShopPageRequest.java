package com.jiejie.mall.shop.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class ShopPageRequest extends BaseRequest {
    private int currentPage;

    private int pageSize;

    private String shopName;
}
