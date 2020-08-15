package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.BrandMapper;
import com.jiejie.mall.brand.model.BrandInfo;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class BrandServiceImp implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    @Transactional
    public Response<Boolean> addBrand(BrandRequest request) {
        Response<Boolean> response = new Response<>();
        BrandInfo brand = BeanCopyUtil.copyProperties(BrandInfo.class,request);

        BrandInfo brandInfo = brandMapper.findBrandByName(brand.getBrandName());
        if(brandInfo==null) {
            int count = brandMapper.addBrand(brand);
            if (count > 0) {
                response.setData(true);
            }
        }else {
            response.setData(true);
        }
        return response;
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
