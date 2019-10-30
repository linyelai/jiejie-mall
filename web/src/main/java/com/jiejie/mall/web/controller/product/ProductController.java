package com.jiejie.mall.web.controller.product;


import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.controller.product.request.AddProductWebRequest;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @PostMapping("/product")
    public CommonWebResponse<Boolean> addProduct(@RequestBody AddProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;

    }
    @PutMapping("/product")
    public CommonWebResponse<Boolean> updateProduct(AddProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;

    }
    @GetMapping("/product")
    public PageResponse<ProductWebResponse> findProduct(FindProductWebRequest webRequest){
        PageResponse<ProductWebResponse> response = new PageResponse<>();
        List<ProductWebResponse> productList = new ArrayList<>();
        for(int i=0;i<10;i++) {
            ProductWebResponse product =  new ProductWebResponse();
            product.setProductName("product"+i);
            product.setBrandId(i);
            product.setCateId(i);
            product.setDesc("product"+i);
            product.setProductImg("https://e-test-future-market.oss-cn-hangzhou.aliyuncs.com/test-product/927/image/10001/5b484e20-fae9-11e9-a9e6-cdd83fecb158.jpg");
            product.setPrice(new BigDecimal(10));
            product.setStatus(1);
            product.setStock(1000);
            productList.add(product);
        }
        response.setData(productList);
        response.setCurrentPage(1);
        response.setPageSize(10);
        return response;

    }
    @GetMapping("/product/detail")
    public CommonWebResponse<ProductWebResponse> findProductById(FindProductWebRequest webRequest){
        CommonWebResponse<ProductWebResponse> response = new CommonWebResponse<>();
        ProductWebResponse product = new ProductWebResponse();
        product.setProductImg("https://e-test-future-market.oss-cn-hangzhou.aliyuncs.com/test-product/927/image/10001/5b484e20-fae9-11e9-a9e6-cdd83fecb158.jpg");
        product.setProductName("华为Mate 30");
        product.setDesc("华为Mate 30");
        product.setCateId(1);
        product.setBrandId(11);
        product.setPrice(new BigDecimal(30));
        product.setStock(100);
        product.setStatus(1);
        product.setLogisticsId(1);
        response.setResult(product);
        return response;

    }
}
