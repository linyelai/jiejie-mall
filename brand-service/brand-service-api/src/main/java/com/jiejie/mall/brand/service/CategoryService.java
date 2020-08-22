package com.jiejie.mall.brand.service;

import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
import com.jiejie.mall.brand.request.DeleteCategoryRequest;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;

public interface CategoryService {
    public Response<Boolean> addCategory(CategoryRequest request);
    public PageResponse<CategoryResponse> findCategory(CategoryPageRequest request);
    public Response<CategoryResponse> findCategoryById(CategoryRequest request);
    public Response<Boolean> updateCategory(CategoryRequest request);
    public Response<Boolean> deleteCategory(DeleteCategoryRequest request);
}
