package com.jiejie.mall.web.controller.brand;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.biz.brand.BrandBiz;
import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.FindBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.brand.response.BrandWebResponse;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {

    @Autowired
    private BrandBiz brandBiz;

    @PostMapping("/brand")
    public CommonWebResponse<Boolean> addBrand(@RequestBody AddBrandWebRequest webResquest){
        return brandBiz.addBrand(webResquest);
    }
    @PutMapping("/brand")
    public CommonWebResponse<Boolean> updateBrand(@RequestBody UpdateBrandWebRequest webResquest){
        return brandBiz.updateBrand(webResquest);
    }
    @GetMapping("/brand")
    public PageResponse<BrandWebResponse> findBrandByPage(FindBrandWebRequest webRequest){
        return brandBiz.findBrandByPage(webRequest);
    }


}
