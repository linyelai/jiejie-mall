package com.jiejie.mall.brand.provider;

import com.jiejie.mall.brand.mapper.CategoryMapper;
import com.jiejie.mall.brand.model.CategoryInfo;
import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
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
        param.put("offset",offset);
        param.put("pageSize",pageSize);
        List<CategoryInfo> categoryInfoList = categoryMapper.findCategoryByPage(param);
        
        return response;
    }

    @Override
    public Response<CategoryResponse> findCategoryById(CategoryRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> updateCategory(CategoryRequest request) {
        return null;
    }

    @Override
    public Response<Boolean> deleteCategory(CategoryRequest request) {
        return null;
    }
}
