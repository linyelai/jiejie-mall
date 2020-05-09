package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.model.CategoryInfo;
import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.mapper.CategoryMapper;
import com.jiejie.mall.brand.service.CategoryService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class CategoryServiceImp  implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Response<Boolean> addCategory(CategoryRequest request) {
        Response<Boolean> response = new Response<>();
        CategoryInfo categoryInfo = BeanCopyUtil.copyProperties(CategoryInfo.class,request);
        int count = categoryMapper.addCategory(categoryInfo);
        if(count>0){
            response.setData(true);
        }else{
            response.setErrorMsg("添加类别失败");
        }
        return response;
    }

    @Override
    public PageResponse<CategoryResponse> findCategory(CategoryPageRequest request) {
        PageResponse<CategoryResponse> response = new PageResponse<>();
        Map param = new HashMap();
        param.put("CategoryName",request.getCategoryName());
        param.put("offset",request.getPageSize()*(request.getCurrentPage()-1));
        param.put("count",request.getPageSize());
        List<CategoryInfo> categoryInfo = categoryMapper.findCategoryByPage(param);
        List<CategoryResponse> categoryResponse = BeanCopyUtil.copyList(CategoryResponse.class,categoryInfo);
        response.setData(categoryResponse);
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response<CategoryResponse> findCategoryById(CategoryRequest request) {
        Response<CategoryResponse> response = new Response<>();
        CategoryInfo categoryInfo = categoryMapper.findCategoryById(request.getId());
        CategoryResponse categoryResponse = BeanCopyUtil.copyProperties(CategoryResponse.class,categoryInfo);
        response.setData(categoryResponse);
        response.setSuccess(true);
        return response;
    }

    @Override
    public Response<Boolean> updateCategory(CategoryRequest request) {
        Response<Boolean> response = new Response<Boolean>() ;
        CategoryInfo categoryInfo = BeanCopyUtil.copyProperties(CategoryInfo.class,request);
        int count = categoryMapper.updateCategory(categoryInfo);
        if(count>0){
            response.setSuccess(true);
        }else{
            response.setErrorMsg("修改类别失败");
        }
        return response;
    }

    @Override
    public Response<Boolean> deleteCategory(CategoryRequest request) {
        Response<Boolean> response = new Response<Boolean>() ;
        CategoryInfo categoryInfo = BeanCopyUtil.copyProperties(CategoryInfo.class,request);
        int count = categoryMapper.deleteCategory(categoryInfo.getId());
        if(count>0){
            response.setSuccess(true);
        }else{
            response.setErrorMsg("修改类别失败");
        }
        return response;
    }
}
