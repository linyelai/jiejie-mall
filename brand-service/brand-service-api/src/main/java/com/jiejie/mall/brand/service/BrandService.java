package com.jiejie.mall.brand.service;

import com.jiejie.mall.brand.request.BrandPageRequest;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.request.DeleteBrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;

public interface BrandService {

    public Response<Boolean> addBrand(BrandRequest request);
    public PageResponse<BrandResponse> findBrand(BrandPageRequest request);
    public Response<BrandResponse> findBrandById(BrandRequest request);
    public Response<Boolean> updateBrand(BrandRequest request);
    public Response<Boolean> deleteBrand(DeleteBrandRequest request);

}
