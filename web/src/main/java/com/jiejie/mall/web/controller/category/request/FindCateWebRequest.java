package com.jiejie.mall.web.controller.category.request;

import com.jiejie.mall.common.request.BaseRequest;
import lombok.Data;

@Data
public class FindCateWebRequest extends BaseRequest {
    private String cateName;
}
