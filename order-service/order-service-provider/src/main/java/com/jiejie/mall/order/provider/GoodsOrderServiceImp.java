package com.jiejie.mall.order.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.order.mapper.GoodsOrderMapper;
import com.jiejie.mall.order.model.GoodsOrderInfo;
import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import com.jiejie.mall.order.request.GoodsOrderRequest;
import com.jiejie.mall.order.response.GoodsOrderResponse;
import com.jiejie.mall.order.service.GoodsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000 )
public class GoodsOrderServiceImp implements GoodsOrderService {

    @Autowired
    private GoodsOrderMapper goodsOrderMapper;

    public Response<Boolean> addGoodsOrder(AddGoodsOrderRequest request){

        Response<Boolean> response = new Response<>();
        GoodsOrderInfo goodsOrderInfo = BeanCopyUtil.copyProperties(GoodsOrderInfo.class,request);
        int result = goodsOrderMapper.addGoodsOrder(goodsOrderInfo);
        if(result>0){
            response.setData(true);
        }else{
            response.setData(false);
        }
        return response;
    }

    public Response<GoodsOrderResponse> findGoodsOrder(GoodsOrderRequest request){

        Response<GoodsOrderResponse> response = new Response<GoodsOrderResponse>();
        Integer id = request.getId();
        GoodsOrderInfo goodsOrderInfo = goodsOrderMapper.findOrderById(id);
        GoodsOrderResponse goodsOrderResponse = BeanCopyUtil.copyProperties(GoodsOrderResponse.class,goodsOrderInfo);
        response.setData(goodsOrderResponse);
        return response;
    }

    public PageResponse<GoodsOrderResponse> findOrderByPage(GoodsOrderRequest request){
        PageResponse<GoodsOrderResponse> response = new PageResponse<GoodsOrderResponse>();
        Map param = new HashMap();
        List<GoodsOrderInfo> goodsOrderInfoList =  goodsOrderMapper.findOrderByPage(param);
        List<GoodsOrderResponse> goodsOrderResponses = BeanCopyUtil.copyList(GoodsOrderResponse.class,goodsOrderInfoList);
        response.setData(goodsOrderResponses);
        return response;
    }
}
