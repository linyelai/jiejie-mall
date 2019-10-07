package com.jiejie.mall.order.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.order.request.*;
import com.jiejie.mall.order.response.MainOrderResponse;
import com.jiejie.mall.order.response.OrderResponse;

import javax.xml.ws.Response;

public interface OrderService {

    public Response<Boolean> addOrder(AddOrderRequest request);

    public Response<OrderResponse> findMainOrder(OrderRequest request);

    public Response<Boolean> updateMainOrder(UpdateOrderRequest request);

    public PageResponse<OrderResponse> findOrderByPage(OrderRequest request);
}
