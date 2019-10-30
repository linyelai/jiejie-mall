package com.jiejie.mall.web.biz.order;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.controller.order.request.FindOrderByPageWebRequest;
import com.jiejie.mall.web.controller.order.response.OrderDetailWebResponse;
import com.jiejie.mall.web.controller.order.response.OrderWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class OrderBiz {


    public PageResponse<OrderWebResponse> findOrderByPage(FindOrderByPageWebRequest webRequest){

        return null;
    }
    public OrderDetailWebResponse detail(IdWebRequest webRequest){

        return null;

    }
}
