package com.jiejie.mall.stock.service;

import com.jiejie.mall.stock.request.UpdateStockRequest;
import com.jiejie.mall.stock.response.BaseResponse;

public interface StockService {

     public BaseResponse<Boolean> updateStock(UpdateStockRequest request);
}
