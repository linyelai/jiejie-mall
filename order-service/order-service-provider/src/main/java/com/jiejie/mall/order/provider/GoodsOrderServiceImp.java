package com.jiejie.mall.order.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import com.jiejie.mall.order.request.GoodsOrderRequest;
import com.jiejie.mall.order.response.GoodsOrderResponse;
import com.jiejie.mall.order.service.GoodsOrderService;

import javax.xml.ws.Response;

public class GoodsOrderServiceImp implements GoodsOrderService {


    public Response<Boolean> addOrder(AddGoodsOrderRequest request){

        return null;
    }

    public Response<GoodsOrderResponse> findGoodsOrder(GoodsOrderRequest request){

        return null;
    }

    public PageResponse<GoodsOrderResponse> findOrderByPage(GoodsOrderRequest request){

        return null;
    }
}
