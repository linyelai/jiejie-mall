package com.jiejie.mall.stock.service;

import com.jiejie.mall.stock.request.UpdateStockRequest;

import com.jiejie.mall.common.response.Response;


public interface StockService {

     public Response<Boolean> updateStock(UpdateStockRequest request);
}
