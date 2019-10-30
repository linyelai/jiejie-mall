package com.jiejie.mall.web.controller.product;


import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.biz.product.ProductBiz;
import com.jiejie.mall.web.controller.product.request.AddProductWebRequest;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductBiz productBiz;
    @PostMapping("/product")
    public CommonWebResponse<Boolean> addProduct(@RequestBody AddProductWebRequest webRequest){
        return productBiz.addProduct(webRequest);

    }
    @PutMapping("/product")
    public CommonWebResponse<Boolean> updateProduct(AddProductWebRequest webRequest){
        return productBiz.updateProduct(webRequest);

    }
    @GetMapping("/product")
    public PageResponse<ProductWebResponse> findProduct(FindProductWebRequest webRequest){
        return productBiz.findProduct(webRequest);

    }
    @GetMapping("/product/detail")
    public CommonWebResponse<ProductWebResponse> findProductById(FindProductWebRequest webRequest){
        return productBiz.findProductById(webRequest);

    }
}
