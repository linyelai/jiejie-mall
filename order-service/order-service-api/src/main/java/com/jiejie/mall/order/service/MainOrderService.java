package com.jiejie.mall.order.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.order.request.AddMainOrderRequest;
import com.jiejie.mall.order.request.MainOrderRequest;
import com.jiejie.mall.order.request.UpdateMainOrderRequest;
import com.jiejie.mall.order.response.MainOrderResponse;

import javax.xml.ws.Response;

public interface MainOrderService {

    public Response<Boolean> addMainOrder(AddMainOrderRequest request);

    public Response<MainOrderResponse> findMainOrder(MainOrderRequest request);

    public Response<Boolean> updateMainOrder(UpdateMainOrderRequest request);

    public PageResponse<MainOrderResponse> findMainOrderByPage(MainOrderRequest request);

}
