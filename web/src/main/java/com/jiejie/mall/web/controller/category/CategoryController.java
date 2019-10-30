package com.jiejie.mall.web.controller.category;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.biz.category.CategoryBiz;
import com.jiejie.mall.web.controller.category.request.AddCateWebRequest;
import com.jiejie.mall.web.controller.category.request.FindCateWebRequest;
import com.jiejie.mall.web.controller.category.request.UpdateCateWebRequest;
import com.jiejie.mall.web.controller.category.response.CateWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryBiz categoryBiz;
    @PostMapping("/category")
    public CommonWebResponse<Boolean> addCate(@RequestBody AddCateWebRequest webResquest){
        return categoryBiz.addCate(webResquest);
    }
    @PutMapping("/category")
    public CommonWebResponse<Boolean> updateCate(@RequestBody UpdateCateWebRequest webResquest){
        return categoryBiz.updateCate(webResquest);
    }
    @GetMapping("/category")
    public PageResponse<CateWebResponse> findCateByPage(FindCateWebRequest webRequest){
        return categoryBiz.findCateByPage(webRequest);
    }
    @DeleteMapping("/category")
    public CommonWebResponse<Boolean> deleteCategory(IdWebRequest webRequest){
        return categoryBiz.deleteCategory(webRequest);

    }

}
