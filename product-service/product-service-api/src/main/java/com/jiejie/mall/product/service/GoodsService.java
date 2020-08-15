package com.jiejie.mall.product.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.*;
import com.jiejie.mall.product.response.GoodsResponse;

public interface GoodsService {

     Response<Boolean> addGoods(AddGoodsRequest request);
     PageResponse<GoodsResponse> findGoodsByPage(GoodsPageRequest request);
     Response<GoodsResponse> findGoods(GoodsRequest goodsRequest);
     Response<Boolean> updateGoods(UpdateGoodsRequest request);
     Response<Boolean> deleteGoods(DeleteGoodsRequest request);
}
