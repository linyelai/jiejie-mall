package com.jiejie.mall.order.mapper;

import com.jiejie.mall.order.model.GoodsOrderInfo;
import com.jiejie.mall.order.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsOrderMapper {
    public int addGoodsOrder(GoodsOrderInfo goodsOrderInfo);
    public int addGoodsOrders(List<GoodsOrderInfo> goodsOrderInfoList);
    public List<GoodsOrderInfo> findOrderByPage(Map param);
    public GoodsOrderInfo findOrderById(Integer id);
    public int count(Map param);
}
