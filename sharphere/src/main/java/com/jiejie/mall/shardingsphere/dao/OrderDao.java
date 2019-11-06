package com.jiejie.mall.shardingsphere.dao;

import com.jiejie.mall.shardingsphere.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderListByUserId(Integer userId);

    void createOrder(Order order);
}