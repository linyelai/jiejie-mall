package com.jiejie.mall.shardingsphere.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

    private int userId;

    private int orderId;
}
