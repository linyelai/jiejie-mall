package com.jiejie.mall.product.provider;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.request.DeleteProductRequest;
import com.jiejie.mall.product.request.ProductPageRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.ProductResponse;
import com.jiejie.mall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class ProductServiceImp implements ProductService {
    public Response<Boolean> addProduct(AddProductRequest request){

        return null;
    }

    public Response<ProductResponse> findProduct(ProductRequest request){

        return null;
    }

    public PageResponse<ProductResponse> findProductByPage(ProductPageRequest request){

        return null;
    }

    public Response<Boolean> updateProduct(ProductRequest request){

        return null;
    }

    public Response<Boolean> deleteProduct(DeleteProductRequest request){

        return null;
    }

}
