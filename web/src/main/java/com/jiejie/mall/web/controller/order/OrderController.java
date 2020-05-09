package com.jiejie.mall.web.controller.order;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.order.OrderBiz;
import com.jiejie.mall.web.controller.order.request.FindOrderByPageWebRequest;
import com.jiejie.mall.web.controller.order.response.OrderDetailWebResponse;
import com.jiejie.mall.web.controller.order.response.OrderWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
