package com.jiejie.mall.order.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.order.request.*;
import com.jiejie.mall.order.response.MainOrderResponse;
import com.jiejie.mall.order.response.OrderResponse;


public interface OrderService {

    public Response<Boolean> addOrder(AddOrderRequest request);

    public Response<OrderResponse> findOrderById(OrderRequest request);

    public Response<Boolean> updateOrder(UpdateOrderRequest request);

    public PageResponse<OrderResponse> findOrderByPage(OrderPageRequest request);
}
