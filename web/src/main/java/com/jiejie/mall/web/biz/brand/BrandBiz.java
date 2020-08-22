package com.jiejie.mall.web.biz.brand;

import com.jiejie.mall.brand.request.BrandPageRequest;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.request.DeleteBrandRequest;
import com.jiejie.mall.brand.request.DeleteCategoryRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.web.controller.brand.request.AddBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.FindBrandWebRequest;
import com.jiejie.mall.web.controller.brand.request.UpdateBrandWebRequest;
import com.jiejie.mall.web.controller.brand.response.BrandWebResponse;
import com.jiejie.mall.web.controller.category.response.CateWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        BrandRequest brandRequest = BeanCopyUtil.copyProperties(BrandRequest.class,webResquest);
        return brandService.updateBrand(brandRequest);
    }
    public PageResponse<BrandWebResponse> findBrandByPage(FindBrandWebRequest webRequest){

        PageResponse<BrandWebResponse> pageResponse = new PageResponse<>();
        BrandPageRequest brandPageRequest = BeanCopyUtil.copyProperties(BrandPageRequest.class,webRequest);
        PageResponse<BrandResponse> response = brandService.findBrand(brandPageRequest);
        List<BrandResponse> brandList = response.getData();
        List<BrandWebResponse> brandWebResponses = BeanCopyUtil.copyList(BrandWebResponse.class,brandList);
        pageResponse.setData(brandWebResponses);
        pageResponse.setTotalPage(response.getTotalPage());
        pageResponse.setTotal(response.getTotal());
        return pageResponse;
    }

    public Response<Boolean> deleteBrand(IdWebRequest webRequest){
        DeleteBrandRequest deleteBrandRequest = new DeleteBrandRequest();
        deleteBrandRequest.setIds(webRequest.getIds());
        return brandService.deleteBrand(deleteBrandRequest);

    }
}
