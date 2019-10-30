package com.jiejie.mall.web.biz.product;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.controller.product.request.AddProductWebRequest;
import com.jiejie.mall.web.controller.product.request.FindProductWebRequest;
import com.jiejie.mall.web.controller.product.response.ProductWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
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

    public CommonWebResponse<Boolean> addProduct(@RequestBody AddProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;

    }
    public CommonWebResponse<Boolean> updateProduct(AddProductWebRequest webRequest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;

    }
    public PageResponse<ProductWebResponse> findProduct(FindProductWebRequest webRequest){
        PageResponse<ProductWebResponse> response = new PageResponse<>();

        return response;

    }
    public CommonWebResponse<ProductWebResponse> findProductById(FindProductWebRequest webRequest){
        CommonWebResponse<ProductWebResponse> response = new CommonWebResponse<>();

        return response;

    }
}
