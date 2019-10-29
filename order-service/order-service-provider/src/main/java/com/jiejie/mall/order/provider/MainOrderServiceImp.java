package com.jiejie.mall.order.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.order.request.AddMainOrderRequest;
import com.jiejie.mall.order.request.MainOrderRequest;
import com.jiejie.mall.order.request.UpdateMainOrderRequest;
import com.jiejie.mall.order.response.MainOrderResponse;
import com.jiejie.mall.order.service.MainOrderService;

import javax.xml.ws.Response;

public  class MainOrderServiceImp implements MainOrderService {

    public Response<Boolean> addMainOrder(AddMainOrderRequest request){
        return  null;

    }

    public Response<MainOrderResponse> findMainOrder(MainOrderRequest request){

        return null;
    }

    public Response<Boolean> updateMainOrder(UpdateMainOrderRequest request){

        return null;
    }

    public PageResponse<MainOrderResponse> findMainOrderByPage(MainOrderRequest request){

        return null;
    }
}
