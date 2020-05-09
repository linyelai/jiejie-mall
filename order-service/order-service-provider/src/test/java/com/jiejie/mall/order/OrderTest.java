package com.jiejie.mall.order;

import com.jiejie.mall.order.request.AddGoodsOrderRequest;
import com.jiejie.mall.order.request.AddOrderRequest;
import com.jiejie.mall.order.request.OrderPageRequest;
import com.jiejie.mall.order.request.OrderRequest;
import com.jiejie.mall.order.response.OrderResponse;
import com.jiejie.mall.order.service.OrderService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class OrderTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.order",check = false)
    private OrderService orderService;
    @Test
    public void addOrder(){

        AddOrderRequest request = new AddOrderRequest();
        AddGoodsOrderRequest goodsOrderRequest = new AddGoodsOrderRequest();
        goodsOrderRequest.setAddress("深圳市");
        goodsOrderRequest.setCount(2);
        goodsOrderRequest.setGoodOrderSn("20200507001001");
        BigDecimal price = new BigDecimal(100);
        goodsOrderRequest.setPrice(price);
        goodsOrderRequest.setGoodsName("华为P30");
        goodsOrderRequest.setReciever("linseven");
        goodsOrderRequest.setRecieverPhone("18312483564");
        goodsOrderRequest.setSku("hw100010");
        goodsOrderRequest.setOrderImg("11111.png");
        goodsOrderRequest.setOrderSn("20200507001");
        BigDecimal discount = new BigDecimal(0.8);
        goodsOrderRequest.setDiscount(price.multiply(discount));
        goodsOrderRequest.setSellPrice(new BigDecimal(0.8));
        BigDecimal totalMoney = price.multiply(new BigDecimal(goodsOrderRequest.getCount()));
        goodsOrderRequest.setTotalMoney(totalMoney);
        request.setGoods(goodsOrderRequest);
        request.setMemberId(1);
        request.setOrderSn("20200507001");
        request.setProductId(1);
        request.setTotalMoney(totalMoney);
        request.setShopId(1);
       orderService.addOrder(request);

    }



}

