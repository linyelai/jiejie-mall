package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.BrandMapper;
import com.jiejie.mall.brand.model.BrandInfo;
import com.jiejie.mall.brand.request.BrandPageRequest;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class BrandServiceImp implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public Response<Boolean> addBrand(BrandRequest request) {

        Response<Boolean> response = new Response<Boolean>() ;
        BrandInfo brandInfo = BeanCopyUtil.copyProperties(BrandInfo.class,request);
        int count = brandMapper.addBrand(brandInfo);
        if(count>0){
            response.setSuccess(true);
        }else{
            response.setErrorMsg("添加品牌失败");
        }
        return response;
    }

    @Override
    public PageResponse<BrandResponse> findBrand(BrandPageRequest request) {
        PageResponse<BrandResponse> pageResponse = new PageResponse<>();
        Map param = new HashMap();
        param.put("brandName",request.getBrandName());
        param.put("offset",request.getPageSize()*(request.getCurrentPage()-1));
        param.put("count",request.getPageSize());
        List<BrandInfo> brandInfoList = brandMapper.findBrandByPage(param);
        List<BrandResponse> brandResponseList = BeanCopyUtil.copyList(BrandResponse.class,brandInfoList);
        pageResponse.setData(brandResponseList);
        pageResponse.setSuccess(true);
        return pageResponse;
    }

    @Override
    public Response<BrandResponse> findBrandById(BrandRequest request) {
        Response<BrandResponse> response = new Response<>();
        BrandInfo brandInfo = brandMapper.findBrandById(request.getId());
        BrandResponse brandResponse = BeanCopyUtil.copyProperties(BrandResponse.class,brandInfo);
        response.setData(brandResponse);
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response<Boolean> updateBrand(BrandRequest request) {
        Response<Boolean> response = new Response<Boolean>() ;
        BrandInfo brandInfo = BeanCopyUtil.copyProperties(BrandInfo.class,request);
        int count = brandMapper.updateBrand(brandInfo);
        if(count>0){
            response.setSuccess(true);
        }else{
            response.setErrorMsg("修改品牌失败");
        }
        return response;
    }

    @Override
    public Response<Boolean> deleteBrand(BrandRequest request) {
        Response<Boolean> response = new Response<Boolean>() ;
        BrandInfo brandInfo = BeanCopyUtil.copyProperties(BrandInfo.class,request);
        int count = brandMapper.deleteBrand(brandInfo.getId());
        if(count>0){
            response.setSuccess(true);
        }else{
            response.setErrorMsg("修改品牌失败");
        }
        return response;
    }
}
