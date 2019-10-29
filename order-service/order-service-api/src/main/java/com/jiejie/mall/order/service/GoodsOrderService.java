package com.jiejie.mall.order.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.order.request.*;
import com.jiejie.mall.order.response.GoodsOrderResponse;
import com.jiejie.mall.order.response.OrderResponse;

import javax.xml.ws.Response;

public interface GoodsOrderService {

    public Response<Boolean> addOrder(AddGoodsOrderRequest request);

    public Response<GoodsOrderResponse> findGoodsOrder(GoodsOrderRequest request);

    public PageResponse<GoodsOrderResponse> findOrderByPage(GoodsOrderRequest request);
}
