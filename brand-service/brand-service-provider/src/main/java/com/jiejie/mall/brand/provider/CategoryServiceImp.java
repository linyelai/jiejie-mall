package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.CategoryMapper;
import com.jiejie.mall.brand.model.CategoryInfo;
import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
import com.jiejie.mall.brand.request.DeleteCategoryRequest;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.service.CategoryService;
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

/**
 * @Author linseven
 * @Date 2020/8/22
 */
@Slf4j
@Service(group = "${dubbo.provider.group}", version = "${dubbo.provider.version}",timeout = 5000)
public class CategoryServiceImp implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;
    
    @Override
    @Transactional
    public Response<Boolean> addCategory(CategoryRequest request) {
        Response<Boolean> response = new Response<>();
        CategoryInfo category = BeanCopyUtil.copyProperties(CategoryInfo.class,request);

        CategoryInfo categoryInfo = categoryMapper.findCategoryByName(category.getCategoryName());
        if(categoryInfo==null) {
            int count = categoryMapper.addCategory(category);
            if (count > 0) {
                response.setData(true);
            }
        }else {
            response.setData(true);
        }
        return response;
    }

    @Override
    public PageResponse<CategoryResponse> findCategory(CategoryPageRequest request) {
        PageResponse<CategoryResponse> response = new PageResponse<CategoryResponse>();
        Map param = new HashMap<>();
        Integer offset = (request.getCurrentPage()-1)*request.getPageSize();
        Integer pageSize = request.getPageSize();
        String categoryName = request.getCategoryName();
        param.put("offset",offset);
        param.put("pageSize",pageSize);
        param.put("categoryName",categoryName);
        List<CategoryInfo> categoryInfoList = categoryMapper.findCategoryByPage(param);
        int total = categoryMapper.count(param);
        int totalPage = 0;
        if(total%pageSize == 0){
            totalPage = total/pageSize;
        }else{
            totalPage = total/pageSize +1;
        }
        response.setTotal(total);
        response.setTotalPage(totalPage);
        response.setData(BeanCopyUtil.copyList(CategoryResponse.class,categoryInfoList));
        return response;
    }

    @Override
    public Response<CategoryResponse> findCategoryById(CategoryRequest request) {

        Response<CategoryResponse> response = new Response<>();
        Integer id = request.getId();
        if(id == null){
            return null;
        }
        CategoryInfo categeoryInfo = categoryMapper.findCategoryById(id);
        CategoryResponse categoryResponse = BeanCopyUtil.copyProperties(CategoryResponse.class,categeoryInfo);
        response.setData(categoryResponse);
        return response;
    }

    @Override
    public Response<Boolean> updateCategory(CategoryRequest request) {

        Response<Boolean> response = new Response<>();
        CategoryInfo categoryInfo = BeanCopyUtil.copyProperties(CategoryInfo.class,request);
        int result = categoryMapper.updateCategory(categoryInfo);
        if(result >0){
            response.setData(true);
        }
        return response;
    }

    @Override
    public Response<Boolean> deleteCategory(DeleteCategoryRequest request) {

        Response<Boolean> response = new Response<>();
        List<Integer> ids = request.getIds();
       int result =  categoryMapper.delete(ids);
       if(result == ids.size()){
           response.setData(true);
       }
        return response;
    }
}
