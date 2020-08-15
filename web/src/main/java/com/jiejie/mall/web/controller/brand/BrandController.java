package com.jiejie.mall.web.controller.brand;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.web.biz.brand.BrandBiz;
import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.FindBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.brand.response.BrandWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BrandController {

    @Autowired
    private BrandBiz brandBiz;

    @PostMapping("/brand")
    public Response<Boolean> addBrand(AddBrandWebRequest webResquest){
        return brandBiz.addBrand(webResquest);
    }
    @PutMapping("/brand")
    public Response<Boolean> updateBrand(@RequestBody UpdateBrandWebRequest webResquest){
        return brandBiz.updateBrand(webResquest);
    }
    @GetMapping("/brand")
    public PageResponse<BrandWebResponse> findBrandByPage(FindBrandWebRequest webRequest){
        return brandBiz.findBrandByPage(webRequest);
    }


}
