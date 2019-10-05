package com.jiejie.mall.product.service;

import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.response.BaseResponse;

public interface ProductService {
    public BaseResponse<Boolean> addProduct(AddProductRequest request);
}
