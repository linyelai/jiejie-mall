package com.jiejie.mall.stock.request;


import lombok.Data;

@Data
public class UpdateStockRequest {
    private Long productId;
    private int num;
    private int action;
}
