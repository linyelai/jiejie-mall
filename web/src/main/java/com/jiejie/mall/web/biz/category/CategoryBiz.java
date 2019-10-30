package com.jiejie.mall.web.biz.category;

import com.jiejie.mall.common.response.PageResponse;
import com.jiejie.mall.web.controller.category.request.AddCateWebRequest;
import com.jiejie.mall.web.controller.category.request.FindCateWebRequest;
import com.jiejie.mall.web.controller.category.request.UpdateCateWebRequest;
import com.jiejie.mall.web.controller.category.response.CateWebResponse;
import com.jiejie.mall.web.controller.request.IdWebRequest;
import com.jiejie.mall.web.controller.response.CommonWebResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class CategoryBiz {

    public CommonWebResponse<Boolean> addCate(@RequestBody AddCateWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }
    public CommonWebResponse<Boolean> updateCate(@RequestBody UpdateCateWebRequest webResquest){
        CommonWebResponse<Boolean> response = new CommonWebResponse<>();
        response.setResult(true);
        return response;
    }
    public PageResponse<CateWebResponse> findCateByPage(FindCateWebRequest webRequest){

        return null;
    }
    public CommonWebResponse<Boolean> deleteCategory(IdWebRequest webRequest){


        return null;

    }

}
