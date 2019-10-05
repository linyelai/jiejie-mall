package com.jiejie.mall.order.service;

import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.response.BaseResponse;

public interface OrderService {

    public BaseResponse<Boolean>  addOrder(AddOrderRequest request);
}
