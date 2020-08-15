package com.jiejie.mall.web.biz.order;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.request.OrderPageRequest;
import com.jiejie.mall.order.request.OrderRequest;
import com.jiejie.mall.order.response.OrderResponse;
import com.jiejie.mall.order.service.OrderService;
import com.jiejie.mall.web.controller.order.request.FindOrderByPageWebRequest;
import com.jiejie.mall.web.controller.order.response.OrderDetailWebResponse;
import com.jiejie.mall.web.controller.order.response.OrderWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OrderBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.order",check = false)
    OrderService orderService;
    public PageResponse<OrderWebResponse> findOrderByPage(FindOrderByPageWebRequest webRequest){

        PageResponse<OrderWebResponse> response = new PageResponse<>();
        OrderPageRequest orderPageRequest = BeanCopyUtil.copyProperties(OrderPageRequest.class,webRequest);
        PageResponse<OrderResponse> orderResponse =  orderService.findOrderByPage(orderPageRequest);
        response.setData(BeanCopyUtil.copyList(OrderWebResponse.class,orderResponse.getData()));
        response.setSuccess(orderResponse.getSuccess());
        return response;
    }
    public Response<OrderDetailWebResponse> detail(IdWebRequest webRequest){

        OrderRequest  orderRequest = BeanCopyUtil.copyProperties(OrderRequest.class,webRequest);
        Response<OrderResponse> orderResponse = orderService.findOrderById(orderRequest);
        Response<OrderDetailWebResponse> response = new Response<>();
        response.setData(BeanCopyUtil.copyProperties(OrderDetailWebResponse.class,orderResponse.getData()));
        response.setSuccess(orderResponse.getSuccess());
        return response;

    }
    public  Response<Boolean> addOrder(AddOrderRequest request){
       return  orderService.addOrder(request);
    }
}
