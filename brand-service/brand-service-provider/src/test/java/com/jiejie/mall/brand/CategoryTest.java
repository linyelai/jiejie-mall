package com.jiejie.mall.brand;

/**
 * @Author linseven
 * @Date 2020/5/7
 */

import com.jiejie.mall.brand.Application;
import com.jiejie.mall.brand.request.CategoryPageRequest;
import com.jiejie.mall.brand.request.CategoryRequest;
import com.jiejie.mall.brand.response.CategoryResponse;
import com.jiejie.mall.brand.service.CategoryService;
import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.common.response.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author linseven
 * @Date 2020/5/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class CategoryTest {

    @Reference(version = "1.0-SNAPSHOT" ,group = "jiejie.mall.brand",check = false)
    private CategoryService categoryService;
    @Test
    public void addCategory(){

        CategoryRequest request = new CategoryRequest();
        request.setCategoryName("华为");
        request.setCategoryDesc("华为");
        request.setCategoryImg("111");
        request.setParentId(0);
        Response<Boolean> response =  categoryService.addCategory(request);
        System.out.println(response.getData());
    }

    @Test
    public void findCategory(){

        CategoryPageRequest request = new CategoryPageRequest();
        request.setCategoryName("华为");
        request.setCurrentPage(1);
        request.setPageSize(20);
        PageResponse<CategoryResponse> response =  categoryService.findCategory(request);
        System.out.println(response.getData());
    }

    @Test
    public void findCategoryById(){

        CategoryRequest request = new CategoryRequest();
        request.setCategoryName("华为");
        request.setId(1);
        Response<CategoryResponse> response =  categoryService.findCategoryById(request);
        System.out.println(response.getData());
    }

    @Test
    public void updateCategory(){

        CategoryRequest request = new CategoryRequest();
        request.setCategoryName("华为");
        request.setCategoryDesc("华为1");
        request.setCategoryImg("111");
        request.setId(1);
        Response<Boolean> response =  categoryService.updateCategory(request);
        System.out.println(response.getData());
    }

}