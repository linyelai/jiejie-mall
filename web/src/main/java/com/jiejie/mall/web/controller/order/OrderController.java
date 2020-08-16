package com.jiejie.mall.web.controller.order;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.request.OrderRequest;
import com.jiejie.mall.product.request.GoodsRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.GoodsResponse;
import com.jiejie.mall.product.response.ProductResponse;
import com.jiejie.mall.product.service.GoodsService;
import com.jiejie.mall.product.service.ProductService;
import com.jiejie.mall.web.biz.order.OrderBiz;
import com.jiejie.mall.web.biz.product.ProductBiz;
import com.jiejie.mall.web.controller.order.request.AddOrderWebRequest;
import com.jiejie.mall.web.controller.order.request.FindOrderByPageWebRequest;
import com.jiejie.mall.web.controller.order.response.OrderDetailWebResponse;
import com.jiejie.mall.web.controller.order.response.OrderWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderBiz orderBiz;

    @GetMapping("/order")
    public PageResponse<OrderWebResponse> findOrderByPage(FindOrderByPageWebRequest webRequest){
        return orderBiz.findOrderByPage(webRequest);
    }
    @GetMapping("/order/detail")
    public Response<OrderDetailWebResponse> detail(IdWebRequest webRequest){

        return orderBiz.detail(webRequest);

    }

    @PostMapping("/order")
    public Response<Boolean> addOrder(@RequestBody AddOrderWebRequest request){
        Response<Boolean> response = new Response<>();
       AddOrderRequest orderRequest = BeanCopyUtil.copyProperties(AddOrderRequest.class,request);
       List<AddGoodsOrderRequest> addGoodsOrderRequestList = BeanCopyUtil.copyList(AddGoodsOrderRequest.class,request.getGoodsOrderInfoList());
       Response<Boolean> response1 =  orderBiz.addOrder(orderRequest,addGoodsOrderRequestList);

        return response;
    }
}
