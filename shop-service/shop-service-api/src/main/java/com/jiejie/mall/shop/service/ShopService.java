package com.jiejie.mall.shop.service;

import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.shop.request.AddShopRequest;

public interface ShopService
{
    Response<Boolean> addShop(AddShopRequest request);
}
