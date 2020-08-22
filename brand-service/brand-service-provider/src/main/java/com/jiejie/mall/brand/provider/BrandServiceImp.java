package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.BrandMapper;
import com.jiejie.mall.brand.model.BrandInfo;
import com.jiejie.mall.brand.model.BrandInfo;
import com.jiejie.mall.brand.model.CategoryInfo;
import com.jiejie.mall.brand.request.BrandPageRequest;
import com.jiejie.mall.brand.request.BrandRequest;
import com.jiejie.mall.brand.request.DeleteBrandRequest;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.response.BrandResponse;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public PageResponse<BrandResponse> findBrand(BrandPageRequest request) {
        PageResponse<BrandResponse> response = new PageResponse<BrandResponse>();
        Map param = new HashMap<>();
        Integer offset = (request.getCurrentPage()-1)*request.getPageSize();
        Integer pageSize = request.getPageSize();
        String brandName = request.getBrandName();
        param.put("offset",offset);
        param.put("pageSize",pageSize);
        param.put("brandName",brandName);
        List<BrandInfo> brandInfoList = brandMapper.findBrandByPage(param);
        int total = brandMapper.count(param);
        int totalPage = 0;
        if(total%pageSize == 0){
            totalPage = total/pageSize;
        }else{
            totalPage = total/pageSize +1;
        }
        response.setTotal(total);
        response.setTotalPage(totalPage);
        response.setData(BeanCopyUtil.copyList(BrandResponse.class,brandInfoList));
        return response;
    }

    @Override
    public Response<BrandResponse> findBrandById(BrandRequest request) {
        Response<BrandResponse> response = new Response<>();
        Integer id = request.getId();
        if(id == null){
            return null;
        }
        BrandInfo brandInfo = brandMapper.findBrandById(id);
        BrandResponse brandResponse = BeanCopyUtil.copyProperties(BrandResponse.class,brandInfo);
        response.setData(brandResponse);
        return response;
    }

    @Override
    public Response<Boolean> updateBrand(BrandRequest request) {
        Response<Boolean> response = new Response<>();
        BrandInfo brandInfo = BeanCopyUtil.copyProperties(BrandInfo.class,request);
        int result = brandMapper.updateBrand(brandInfo);
        if(result >0){
            response.setData(true);
        }
        return response;
    }

    @Override
    public Response<Boolean> deleteBrand(DeleteBrandRequest request) {
        Response<Boolean> response = new Response<>();
        List<Integer> ids = request.getIds();
        int result =  brandMapper.delete(ids);
        if(result == ids.size()){
            response.setData(true);
        }
        return response;
    }
}
