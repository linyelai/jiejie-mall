package com.jiejie.mall.order.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.order.mapper.GoodsOrderMapper;
import com.jiejie.mall.order.mapper.OrderMapper;
import com.jiejie.mall.order.model.GoodsOrderInfo;
import com.jiejie.mall.order.model.OrderInfo;
import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.request.OrderPageRequest;
import com.jiejie.mall.order.request.OrderRequest;
import com.jiejie.mall.order.request.UpdateOrderRequest;
import com.jiejie.mall.order.response.OrderResponse;
import com.jiejie.mall.order.service.OrderService;
import com.jiejie.mall.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;
    //@Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.stock",check = false)
   // private StockService stockService;

    public Response<Boolean> addOrder(AddOrderRequest request){

        Response<Boolean> response = new Response<>();
        OrderInfo orderInfo = BeanCopyUtil.copyProperties(OrderInfo.class,request);
        int result = orderMapper.addOrder(orderInfo);


        if(result>0){
            GoodsOrderInfo goodsOrderInfo = BeanCopyUtil.copyProperties(GoodsOrderInfo.class,request.getGoods());
            result = goodsOrderMapper.addGoodsOrder(goodsOrderInfo);
            if(result>0){
                response.setData(true);
            }else{
                response.setData(false);
            }

        }else{
            response.setData(false);
        }
        return response;
    }

    public Response<OrderResponse> findOrderById(OrderRequest request){
        Response<OrderResponse> response = new Response<>();
        Integer id = request.getId();
        OrderInfo orderInfo =  orderMapper.findOrderById(id);
        OrderResponse result = BeanCopyUtil.copyProperties(OrderResponse.class,orderInfo);
        response.setData(result);
        return response;
    }

    public Response<Boolean> updateOrder(UpdateOrderRequest request){

        Response<Boolean> response = new Response<>();
        OrderInfo orderInfo = BeanCopyUtil.copyProperties(OrderInfo.class,request);
        int result = orderMapper.updateOrder(orderInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }

    public PageResponse<OrderResponse> findOrderByPage(OrderPageRequest request){

        PageResponse<OrderResponse> response = new PageResponse<>();
        OrderInfo orderInfo = BeanCopyUtil.copyProperties(OrderInfo.class,request);
        Map param = new HashMap<>();
        param.put("orderSn",request.getOrderSn());
        param.put("currentPage",request.getCurrentPage());
        param.put("pageSize",request.getPageSize());
        param.put("status",request.getStatus());
        param.put("sellerId",request.getSellerId());
        param.put("startTime",request.getStartTime());
        param.put("endTime",request.getEndTime());
        List<OrderInfo> orderInfos = orderMapper.findOrderByPage(param);
        List<OrderResponse> orderResponses = BeanCopyUtil.copyList(OrderResponse.class,orderInfos);
        response.setData(orderResponses);
        return response;
    }
}
