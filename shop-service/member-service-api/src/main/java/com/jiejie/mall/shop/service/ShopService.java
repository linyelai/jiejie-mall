package com.jiejie.mall.shop.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.shop.request.*;
import com.jiejie.mall.shop.response.ShopResponse;

public interface ShopService {
     public Response<Boolean> addShop(AddShopRequest request);

     public Response<ShopResponse> findShopByName(ShopRequest request);
     public Response<ShopResponse> findShopById(ShopRequest request);

     public Response<Boolean> updateShop(UpdateShopRequest request);

     public Response<Boolean> deleteShop(DeleteShopRequest request);

     public PageResponse<ShopResponse> findShopByPage(ShopPageRequest request);
}
