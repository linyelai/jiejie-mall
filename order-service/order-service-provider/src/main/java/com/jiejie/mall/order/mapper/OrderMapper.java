package com.jiejie.mall.order.mapper;

import com.jiejie.mall.order.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    public int addOrder(OrderInfo orderInfo);
    public int updateOrder(OrderInfo orderInfo);
    public List<OrderInfo> findOrderByPage(Map param);
    public OrderInfo findOrderById(Integer id);
    public int count(Map param);
}
