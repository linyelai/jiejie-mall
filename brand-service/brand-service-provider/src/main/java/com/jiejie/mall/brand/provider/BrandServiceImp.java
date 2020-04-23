package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.BrandMapper;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Response;

@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class BrandServiceImp implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public Response<Boolean> addBrand(BrandRequest request) {

        return null;
    }

    @Override
    public PageResponse<BrandResponse> findBrand(BrandRequest request) {
        return null;
    }

    @Override
    public Response<BrandResponse> findBrandById(BrandRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> updateBrand(BrandRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> deleteBrand(BrandRequest request) {
        return null;
    }
}
