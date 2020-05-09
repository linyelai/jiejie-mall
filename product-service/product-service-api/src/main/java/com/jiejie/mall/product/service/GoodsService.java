package com.jiejie.mall.product.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.*;
import com.jiejie.mall.product.response.GoodsResponse;


public interface GoodsService {

    public Response<Boolean> addGoods(AddGoodsRequest request);

    public PageResponse<GoodsResponse> findGoods(GoodsPageRequest request);

    public Response<GoodsResponse> findById(GoodsRequest reques);

    public Response<Boolean> updateGoods(GoodsRequest request);

    public Response<Boolean> deleteGooods(DeleteGoodsRequest request);
}
