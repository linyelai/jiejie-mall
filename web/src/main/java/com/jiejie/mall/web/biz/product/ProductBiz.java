package com.jiejie.mall.web.biz.product;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.product.request.AddProductRequest;
import com.jiejie.mall.product.request.DeleteProductRequest;
import com.jiejie.mall.product.request.ProductPageRequest;
import com.jiejie.mall.product.request.ProductRequest;
import com.jiejie.mall.product.response.ProductResponse;
import com.jiejie.mall.product.service.ProductService;
import com.jiejie.mall.web.controller.product.request.ProductWebRequest;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBiz {

   @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.product",check = false)
   ProductService productService;
    public CommonWebResponse<Boolean> addProduct(@RequestBody ProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        AddProductRequest addProductRequest = BeanCopyUtil.copyProperties(AddProductRequest.class,webRequest);
       Response<Boolean>  addProductResponse = productService.addProduct(addProductRequest);
        response.setResult(addProductResponse.getData());
        return response;

    }
    public CommonWebResponse<Boolean> updateProduct(ProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        ProductRequest productRequest = BeanCopyUtil.copyProperties(ProductRequest.class,webRequest);
        Response<Boolean> updateProductResp = productService.updateProduct(productRequest);
        response.setResult(updateProductResp.getData());
        return response;

    }
    public PageResponse<ProductWebResponse> findProduct(FindProductWebRequest webRequest){
        PageResponse<ProductWebResponse> response = new PageResponse<>();
        ProductPageRequest productPageRequest = BeanCopyUtil.copyProperties(ProductPageRequest.class,webRequest);
        PageResponse<ProductResponse> productResponse = productService.findProductByPage(productPageRequest);
        response.setSuccess(productResponse.getSuccess());
        List<ProductWebResponse> productWebResponse = BeanCopyUtil.copyList(ProductWebResponse.class,productResponse.getData());
        response.setData(productWebResponse);
        return response;

    }
    public CommonWebResponse<ProductWebResponse> findProductById(FindProductWebRequest webRequest){
        CommonWebResponse<ProductWebResponse> response = new CommonWebResponse<>();
        ProductRequest productRequest = BeanCopyUtil.copyProperties(ProductRequest.class,webRequest);
        Response<ProductResponse> productResponse = productService.findProduct(productRequest);
        ProductWebResponse productWebResponse = BeanCopyUtil.copyProperties(ProductWebResponse.class,productResponse.getData());
        response.setResult(productWebResponse);
        return response;

    }

    public CommonWebResponse<Boolean> deleteProductById(FindProductWebRequest request){

        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        DeleteProductRequest deleteProductRequest = BeanCopyUtil.copyProperties(DeleteProductRequest.class,request);
        Response<Boolean> deleteResponse = productService.deleteProduct(deleteProductRequest);
        response.setResult(deleteResponse.getData());
        return response;

    }
}
