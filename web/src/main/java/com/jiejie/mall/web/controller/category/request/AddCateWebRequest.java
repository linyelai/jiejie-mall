package com.jiejie.mall.web.controller.category.request;

import com.jiejie.mall.token.request.BaseRequest;
import lombok.Data;

@Data
public class AddCateWebRequest extends BaseRequest {

    private String cateName;
    private String desc;

}
