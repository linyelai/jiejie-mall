package com.jiejie.mall.product.service;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.request.DeleteProductRequest;
import com.jiejie.mall.product.request.ProductPageRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.ProductResponse;

public interface ProductService {
    public Response<Boolean> addProduct(AddProductRequest request);

    public Response<ProductResponse> findProduct(ProductRequest request);

    public PageResponse<ProductResponse> findProductByPage(ProductPageRequest request);

    public Response<Boolean> updateProduct(ProductRequest request);

    public Response<Boolean> deleteProduct(DeleteProductRequest request);
}
