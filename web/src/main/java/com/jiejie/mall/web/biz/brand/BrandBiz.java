package com.jiejie.mall.web.biz.brand;

import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.FindBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.brand.response.BrandWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BrandBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.brand",check = false)
    private BrandService brandService;

    public Response<Boolean> addBrand(@RequestBody AddBrandWebRequest webResquest){
        Response<Boolean> response = new Response<>();
        BrandRequest brandRequest = BeanCopyUtil.copyProperties(BrandRequest.class,webResquest);
        return brandService.addBrand(brandRequest);

    }
    public Response<Boolean> updateBrand(@RequestBody UpdateBrandWebRequest webResquest){
        Response<Boolean> response = new Response<>();
        response.setData(true);
        return response;
    }
    public PageResponse<BrandWebResponse> findBrandByPage(FindBrandWebRequest webRequest){

        return null;
    }
}
