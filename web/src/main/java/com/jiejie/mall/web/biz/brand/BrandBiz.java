package com.jiejie.mall.web.biz.brand;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.FindBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.brand.response.BrandWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BrandBiz {

    public CommonWebResponse<Boolean> addBrand(@RequestBody AddBrandWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }
    public CommonWebResponse<Boolean> updateBrand(@RequestBody UpdateBrandWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }
    public PageResponse<BrandWebResponse> findBrandByPage(FindBrandWebRequest webRequest){

        return null;
    }
}
