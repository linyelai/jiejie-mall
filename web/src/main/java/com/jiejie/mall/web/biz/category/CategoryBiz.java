package com.jiejie.mall.web.biz.category;

import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
import com.jiejie.mall.brand.request.DeleteCategoryRequest;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.service.BrandService;
import com.jiejie.mall.brand.service.CategoryService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import com.jiejie.mall.common.utils.BeanCopyUtil;
import com.jiejie.mall.web.controller.category.request.AddCateWebRequest;
import com.jiejie.mall.web.controller.category.request.FindCateWebRequest;
import com.jiejie.mall.web.controller.category.request.UpdateCateWebRequest;
import com.jiejie.mall.web.controller.category.response.CateWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CategoryBiz {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.brand",check = false)
    private CategoryService categoryService;

    public Response<Boolean> addCate(@RequestBody AddCateWebRequest webResquest){
        CategoryRequest request = BeanCopyUtil.copyProperties(CategoryRequest.class,webResquest);
        Response<Boolean> response = categoryService.addCategory(request);
        return response;
    }
    public Response<Boolean> updateCate(@RequestBody UpdateCateWebRequest webResquest){

        CategoryRequest categoryRequest = BeanCopyUtil.copyProperties(CategoryRequest.class,webResquest);
        return categoryService.updateCategory(categoryRequest);
    }
    public PageResponse<CateWebResponse> findCateByPage(FindCateWebRequest webRequest){

        PageResponse<CateWebResponse> pageResponse = new PageResponse<>();
        CategoryPageRequest categoryPageRequest = BeanCopyUtil.copyProperties(CategoryPageRequest.class,webRequest);
        PageResponse<CategoryResponse> response = categoryService.findCategory(categoryPageRequest);
        List<CategoryResponse> categoryList = response.getData();
        List<CateWebResponse> cateWebResponses = BeanCopyUtil.copyList(CateWebResponse.class,categoryList);
        pageResponse.setData(cateWebResponses);
        pageResponse.setTotalPage(response.getTotalPage());
        pageResponse.setTotal(response.getTotal());
        return pageResponse;
    }
    public Response<Boolean> deleteCategory(IdWebRequest webRequest){

        DeleteCategoryRequest deleteCategoryRequest = new DeleteCategoryRequest();
        deleteCategoryRequest.setIds(webRequest.getIds());
        return categoryService.deleteCategory(deleteCategoryRequest);

    }

}
