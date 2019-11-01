package com.jiejie.mall.order.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.order.request.*;
import com.jiejie.mall.order.response.GoodsOrderResponse;
import com.jiejie.mall.order.response.OrderResponse;



public interface GoodsOrderService {

    public Response<Boolean> addGoodsOrder(AddGoodsOrderRequest request);

    public Response<GoodsOrderResponse> findGoodsOrder(GoodsOrderRequest request);

    public PageResponse<GoodsOrderResponse> findOrderByPage(GoodsOrderRequest request);
}
